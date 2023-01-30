package phone_directory;

public
class PhoneDirectory2 {
    int max;
    int pos = 0;
    int[] next;

    public PhoneDirectory2(int maxNumbers) {
        next = new int[maxNumbers];
        max = maxNumbers;
        for (int i = 0; i < max; i++) {
            next[i] = (i + 1) % max;
        }

    }

    public int get() {
        if (next[pos] == -1) return -1;
        int ret = pos;
        pos = next[pos];
        next[ret] = -1;
        return ret;
    }

    public boolean check(int number) {
        return next[number] != -1;
    }

    public void release(int number) {
        if (next[number] != -1) return;
        next[number] = pos;
        pos = number;
    }

    public static void main(String[] args) {
        PhoneDirectory2 pd2 = new PhoneDirectory2(10);
        for(int i= 0 ; i < 5;i++) {
            System.out.println(pd2.get());
        }
        for(int i= 0 ; i < 5;i++) {
            pd2.release(i);
        }

        for(int i = 0 ; i < 10;i++) {
            System.out.println(pd2.get());
        }
    }
}
