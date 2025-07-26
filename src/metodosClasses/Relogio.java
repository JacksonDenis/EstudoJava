package metodosClasses;

public class Relogio {
    private int h, m, s;               // 0 ≤ h < 24, 0 ≤ m,s < 60

    public Relogio(int h, int m, int s) {
        if (h<0||h>23||m<0||m>59||s<0||s>59) throw new IllegalArgumentException();
        this.h = h; this.m = m; this.s = s;
    }

    public void tic(){
        s++;
        if (s == 60) {
            s = 0;
            m++;
            if (m == 60) {
                m = 0;
                h++;
                if (h == 24) {
                    h = 0;
                }
            }
        }
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", h, m, s);
    }


}
