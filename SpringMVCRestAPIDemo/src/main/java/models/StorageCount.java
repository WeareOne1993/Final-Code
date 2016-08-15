package models;

import java.util.ArrayList;
import java.util.List;

public class StorageCount
{
    private static List<StorageSearch> storageSearchs;
    private static int size;
    
    public StorageCount()
    {
        this.storageSearchs = new ArrayList<StorageSearch>();
        this.size = 0;
    }

    public static List<StorageSearch> getStorageSearchs() {
        return storageSearchs;
    }

    public static void setStorageSearchs(List<StorageSearch> storageSearchs) {
        StorageCount.storageSearchs = storageSearchs;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        StorageCount.size = size;
    }
}
