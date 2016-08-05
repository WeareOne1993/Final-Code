use newdb;

drop table if exists productdemo;
create table productdemo
(
	id int not null auto_increment,
    name varchar(100) not null,
    type enum('NULL', 'watch', 'jewelry')null default NULL,
    brand varchar(20) NULL default null,
    model varchar(20) NULL default null, #awtch/ moto
    gender varchar(10) NULL default NULL,
    movement varchar(20) NULL default null,
    watchlabel varchar(20) NULL default null,
    casesize decimal(6,2) NULL default 0,
    casethickness decimal(6,2) NULL default 0,
    casematerial varchar(20) NULL default null,
    caseshape varchar(20)  NULL default null,
    dialtype varchar(20) NULL default null,
    dialcolor varchar(10) NULL default null,
    crystal varchar(30) NULL default null,
    waterresistance varchar(30) NULL default null,
    
    #totalcaratweight varchar(20) NULL default null,
    #sidestonediamondclarity varchar(10) NULL default null,
    #sidestonediamondcolour varchar(10) NULL default null,
    #sidestonediamondcut varchar(20) NULL default null,
    #sidestonediamondsetting varchar(20) NULL default null,
    #metalcontent varchar(20) NULL default null,
    #metalcolour varchar(20) NULL default null,
    
    metal varchar(30) NULL default null,
    clasp varchar(30) NULL default null,
    chainlength decimal(6,2) null default 0,
    chaintype varchar(20) null default null,
    width decimal(6,2) null default 0,
    length decimal(6,2) null default 0,
    rhodiumplated varchar(5) null default null,
    numberofcenterrounddiamonds int null default 0,
    minimumcarattotalweight decimal(5,2) null default 0,
    minimumcolor varchar(10) null default null,
    minimumclarity varchar(10) null default null,
    minimumcut varchar(15) null default null,
    settingtype varchar(20) null default null,
    
    
#	stocknumber varchar(20)  NULL default null,
#    year int null default NULL,
#	make enum('NULL', 'yamaha', 'ducati') NULL default null,
#    VIN varchar(30)  NULL default null,
#    color varchar(10)  NULL default null,
#    weight decimal(6,2)  NULL default null,
    
    
    price decimal(10,2) not null default 0,
    path varchar(100) NULL default null,
    
    
    
    primary key (id)
);
alter table productdemo auto_increment = 0;

drop procedure if exists insertValueProductDemo;

delimiter //
create procedure insertValueProductDemo()
begin
	declare c int;
    declare numberofwatch int;
    declare numberofjewelry int;
    
	declare iname varchar(100);
    
    #watch
	declare itypewatch varchar(20);
	declare ibrand varchar(20);
	declare imodel varchar(20);
	declare igender varchar(10);
	declare imovement varchar(20);
	declare iwatchlabel varchar(20);
	declare icasesize decimal(6,2);
	declare icasethickness decimal(6,2);
	declare icasematerial varchar(20);
	declare icaseshape varchar(20);
	declare idialtype varchar(20);
	declare idialcolor varchar(10);
	declare icrystal varchar(30);
	declare iwaterresistance varchar(30);
    
    #jewelry
    declare itypejewelry varchar(20);
    declare imetal varchar(30);
    declare iclasp varchar(30);
    declare ichainlength decimal(6,2);
    declare ichaintype varchar(20);
    declare iwidth varchar(15); 
    declare ilength varchar(15);
    declare irhodiumplated varchar(5); 
    declare inumberofcenterrounddiamonds int;
    declare iminimumcarattotalweight decimal(5,2);
    declare iminimumcolor varchar(10);
    declare iminimumclarity varchar(10);
    declare iminimumcut varchar(15);
    declare isettingtype varchar(20); 
    declare random int;
    declare randomname int;
    
    declare iprice decimal(10,2);
    declare ipath varchar(100);
    
	set c = 1;
    set numberofwatch = 18;
    set numberofjewelry = 20;



    
	l1: WHILE c <= numberofwatch DO
		set ibrand =  ELT(FLOOR(1 + RAND()*7), 'Citizen', 'Rolex', 'IWC', 'Omega', 'Tissot', 'Hamilton', 'Seiko');
		set igender = ELT(FLOOR(1 +rand()*2), 'Men\'s', 'Ladies');
		set imodel = CONCAT(
			UPPER(substr(ibrand,1,2)),
			substr('0123456789', floor(rand()*10+1),1),
			substr('0123456789', floor(rand()*10+1),1),
			substr('0123456789', floor(rand()*10+1),1),
			substr('0123456789', floor(rand()*10+1),1),
			'-',
			substr('0123456789', floor(rand()*10+1),1),
			substr('0123456789', floor(rand()*10+1),1),
			substr(igender,1, 1)    
		);
		set itypewatch = 'watch';
		set imovement = ELT(FLOOR(1 + RAND()*3), 'Eco-Drive', 'Automatic', 'Quartz');
		set iwatchlabel = ELT(FLOOR(1 + RAND()*3), 'Japan Movt', 'Made in Japan', 'Swiss made');
		set icasesize = ROUND(RAND()*7+40, 2);
		set icasethickness = ROUND(RAND()*6+9, 2);
		set icasematerial = ELT(FLOOR(1+ RAND()*2), 'Stainless Steel', 'Titanium');
        set icaseshape = 'Round';
        set idialtype = 'Analog';
        set idialcolor = ELT(FLOOR(RAND()*5+1), 'Blue', 'Black', 'Green', 'White', 'Silver');
        set icrystal = ELT(FLOOR(RAND()*4+1), 'Scratch Resistant Sapphire', 'Mineral', 'Sapphire', 'Hardlex');
        set iwaterresistance= ELT(FLOOR(RAND()*4+1),'30 meters/ 100 feet', '100 meters / 330 feet', '300 meters / 1000 feet', '200 meters / 660 feet');
        set iname = CONCAT(
			ibrand,
            ' ',
            substr(imodel, 3, 7),
			' ',
            idialcolor,
            ' ',
            igender,
            ' watch'
        );
         set iprice = FLOOR(RAND()*8000+1000);
         set ipath = CONCAT(
			'\\img\\watch\\',
            c,
            '.jpg'
         );
        
	  INSERT INTO productdemo(name, type, brand, model, gender, movement, watchlabel, casesize, casethickness, casematerial, caseshape, dialtype, dialcolor, crystal, waterresistance, price, path) values (
			iname,
			itypewatch,
			ibrand,
			imodel,
			igender,
			imovement,
			iwatchlabel,
			icasesize,
			icasethickness,
			icasematerial,
			icaseshape,
			idialtype,
			idialcolor,
			icrystal,
			iwaterresistance,
			iprice,
            ipath
			);
			set c = c + 1;
	end while l1;
    
    #insert jewelry
	l2: WHILE c <= numberofwatch+numberofjewelry DO
		set random = floor(rand()*5+1);
        set randomname = floor(rand()*3+1);
        set itypejewelry = 'jewelry';
        set imetal = ELT(randomname, '950 Platinum', '14k Yellow Gold', '14k White Gold');
        set iclasp = ELT(FLOOR(RAND()*2+1), 'Lobster claw clasp', 'Spring ring clasp');
        set ichainlength = ELT(FLOOR(RAND()*2+1), '18.0', '20.0');
        set ichaintype = ELT(FLOOR(RAND()*2+1), 'Wheat Chain', 'Cable Chain');
        set iwidth = ROUND(FLOOR(RAND()*(random*2)+1)/(random*2), 2);
        set ilength = ROUND(FLOOR(RAND()*(random*2)+1)/(random*2), 2);
        set irhodiumplated = ELT(FLOOR(RAND()*2+1), 'Yes', 'No');
        set inumberofcenterrounddiamonds = FLOOR(RAND()*50+1);
        set iminimumcarattotalweight = ROUND(RAND()*2, 2);
        set iminimumcolor = ELT(FLOOR(RAND()*8+1), 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K-Z');
        set iminimumclarity = ELT(FLOOR(RAND()*6+1), 'FL-IF', 'VVS1-VVS2', 'VS1-VS2', 'SI1-SI2', 'I1', 'I2');
        set iminimumcut= ELT(FLOOR(RAND()*4+1), 'Signature Ideal', ' Ideal', 'Very Good', 'Good');
        set isettingtype = ELT(FLOOR(RAND()*3+1), 'Prong setting', 'Bezel setting', 'Pave setting');
        set iname = CONCAT(
			ELT(randomname, 'PL', 'YG', 'WG'),
			substr('0123456789', floor(rand()*10+1),1),
			substr('0123456789', floor(rand()*10+1),1),
			substr('0123456789', floor(rand()*10+1),1),
			substr('0123456789', floor(rand()*10+1),1),
			'-',
            substr(iclasp, 1, 1),
            substr(ichaintype, 1, 1),
			substr('0123456789', floor(rand()*10+1),1),
			substr('0123456789', floor(rand()*10+1),1)
        );
        set iprice = FLOOR(RAND()*9900+1000);
		set ipath = CONCAT(
			'\\img\\jewelry\\',
            c-numberofwatch,
            '.jpg'
         );
        
	  INSERT INTO productdemo(name, type, metal, clasp, chainlength, chaintype, width, length, rhodiumplated, numberofcenterrounddiamonds, minimumcolor, minimumcarattotalweight, minimumclarity, minimumcut,settingtype, price, path) values (
			iname,
            itypejewelry,
            imetal,
            iclasp,
            ichainlength,
            ichaintype,
            iwidth,
            ilength,
            irhodiumplated,
            inumberofcenterrounddiamonds,
            iminimumcolor,
            iminimumcarattotalweight,
            iminimumclarity,
            iminimumcut,
            isettingtype,
            iprice,
            ipath
			);
            
			set c = c + 1;
 end while l2;
 
 
end;//

call insertValueProductDemo;//