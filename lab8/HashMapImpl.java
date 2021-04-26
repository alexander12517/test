package lab8;

class Entry {
    Object key;
    Object val;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int mul = 11;
        System.out.println("hashcode befor " + hashCode());
        if (key != null) {
            int hashCode = prime * mul + key.hashCode();
            System.out.println("hashcode after " + hashCode());
            return hashCode;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Entry e = (Entry) o;
        return this.key == e.key;
    }
}

public class HashMapImpl {
    private int capacity = 100;
    private int size = 0;
    private Entry table[] = new Entry[capacity];

    public static void main(String[] args) {
        HashMapImpl hashMap = new HashMapImpl();
        hashMap.put(10, "Apple");
        hashMap.put(1, "Orange");
        hashMap.put(79, "Grape");
        System.out.println("Val at 79 " + hashMap.get(79));
        System.out.println("Val at 1 " + hashMap.get(1));
        System.out.println("Val at 10 " + hashMap.get(10));
        System.out.println("Val at 2 " + hashMap.get(2));
        hashMap.put(null, "Pear");
        System.out.println("Val at null " + hashMap.get(null));
        System.out.println("Hashmap has key at null:" + hashMap.containsKey(null));
        System.out.println("Hashmap has value at null:" + hashMap.containsValue("Pear"));
        System.out.println("Size of Map:" + hashMap.size());
    }

    private int hashing(int hashCode) {
        int location = hashCode % capacity;
        System.out.println("Location:" + location + "hashCode " + hashCode);
        return location;
    }

    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean containsKey(Object key) {
        if (key == null && table[0].getKey() == null) {
            return true;
        }
        //??? ???????? ?? Null, ????? ???? ???????? NullPointerException
        int location = hashing(key.hashCode());
        Entry e = table[location];
        return e != null && e.getKey() == key;
    }

    public boolean containsValue(Object value) {
        for (Entry entry : table) {
            if (entry != null && entry.getVal() == value) {
                return true;
            }
        }
        return false;
    }

    public Object get(Object key) {
        Object ret = null;
        if (key == null) {
            Entry e = null;
            e = table[0];
            if (e != null) {
                return e.getVal();
            }
        } else {
            int location = hashing(key.hashCode());
            Entry e = null;
            e = table[location];
            if (e != null && e.getKey() == key) {
                return e.getVal();
            }
        }
        return ret;
    }

    public Object put(Object key, Object val) {
        Object ret = null;
        if (key == null) {
            ret = putForNullKey(val);
            return ret;
        } else {
            int location = hashing(key.hashCode());
            if (location >= capacity) {
                System.out.println("Rehashing required");
                return null;
            }
            Entry e = null;
            e = table[location];
            if (e != null && e.getKey() == key) {
                ret = e.getVal();
            } else {
                Entry eNew = new Entry();
                eNew.setKey(key);
                eNew.setVal(val);
                table[location] = eNew;
                size++;
            }
        }
        return ret;
    }

    private Object putForNullKey(Object val) {
        Entry e = null;
        e = table[0];
        Object ret = null;
        if (e != null && e.getKey() == null) {
            ret = e.getVal();
            e.setVal(val);
            return ret;
        } else {
            Entry eNew = new Entry();
            eNew.setKey(null);
            eNew.setVal(val);
            table[0] = eNew;
            size++;
        }
        return ret;
    }

    public Object remove(Object key) {
        int location = hashing(key.hashCode());
        Object ret = null;
        if (table[location].getKey() == key && table.length - location >= 0) {
            System.arraycopy(table, location + 1, table, location, table.length - location);
        }
        return ret;
    }


}
