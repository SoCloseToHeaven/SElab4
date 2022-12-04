package utils;

import java.util.ArrayList;

public final class CachedNames {
    static private ArrayList<String> usedNames = new ArrayList<String>();

    private CachedNames() {}

    static public boolean isNotCached(String name) {
        boolean isNotCachedFlag = true;
        for (String iter : usedNames)
            isNotCachedFlag = (name.intern() == iter.intern()) ? false : isNotCachedFlag;
        return isNotCachedFlag;
    }

    static void cacheName(String name) {
        usedNames.add(name);
    }
    @Override
    public boolean equals(Object obj) { // не имеет смысла, тк создать объект класса невозможно
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass())
            return true;
        return false;
    }

    @Override
    public int hashCode() { // у объекта класса нет полей, да и смысла не имеет
        return 31; //константа хэш кода
    }

    @Override
    public String toString() { // тоже смысла не имеет
        return "";
    }
}
