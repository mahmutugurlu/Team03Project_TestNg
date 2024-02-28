package allovercommerce.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener , IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart==> Tum testlerden once tek bir kere cagirilir  :  "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish==> Tum testlerden sonra tek bir kere cagirilir  :  " +context.getName() );
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart==> her bir @Test ten once bir kere cagirilir  :  "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess==> sadece pass olan testlerden sonra bir kere cagirilir  :  "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure==> sadece fail olan testlerden sonra bir kere cagirilir  :  "+result.getName());
        ReusableMethods.screenShot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped==> sadece atlanan testlerden sonra bir kere cagirilir  :  "+result.getName());
    }


    /*
    Bu methodu sadece fail olan test methodlarimizin kac kere tekrardan calistirilmasini belirlemek icin olusturduk
    maxRetryCount = 1; ==> ek olarak calisma sayisidir
    Bu ornekte fail olan test normal bir kere calistiktan sonra bir kere daha bu methodun calismasini saglayacak
    buraya kac yazarsak o kadar tekrar calisacak
     */
    private static int retryCount = 0;
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    /*
    Bu method yukarida yazmis oldugumuz retry methoduna yardimci olur ve bu retry methodunun
    xml dosyasi uzerinden kullanabilmemizi saglar
    ve boylece arka planda @Test notasyonunan sahip olan methodlari yapilandirip testin basarisiz
    olma durumunda otomatik olarak retry methodunda belirttigimiz sayi kadar tekrar calistirabilmemizi saglar
    Eger bu methodu burada yazmazsak yeniden calistirma icin ilgili methodlara monual olarak yazmamiz gerekcek
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Listeners.class);
    }



}