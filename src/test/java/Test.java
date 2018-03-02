import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.functions.Action1;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] s){
        Observable.interval(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                LoggerFactory.getLogger(this.getClass()).info("==============" + aLong);
            }
        });
    }
}
