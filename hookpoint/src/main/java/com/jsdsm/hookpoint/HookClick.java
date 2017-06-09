package com.jsdsm.hookpoint;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Toast-pc on 2017/6/5.
 */

@Aspect
public class HookClick {

    @Before("execution(* *.onClick(..))")
    public void onClickBefore(JoinPoint joinPoint) throws Throwable {
        View view = (View)joinPoint.getArgs()[0];
        String name = view.getResources().getResourceName(view.getId());
        if (view instanceof TextView){
            System.out.println("xxxxx           "+"onClickBefore: " + name);
        }else if (view instanceof ImageView){
            ImageView img= ((ImageView) view);
            System.out.println("xxxxx           "+"onClickBefore: " + name);
        }else {
            System.out.println("xxxxx           "+"onClickBefore: " + view.getClass().getSimpleName());
        }
    }
}
