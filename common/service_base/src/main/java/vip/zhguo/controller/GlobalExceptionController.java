package vip.zhguo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.zhguo.commonutils.ExceptionUtil;
import vip.zhguo.commonutils.R;

/**
 * [全局异常类]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/4/27 14:02]
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.error().data(e.getMessage());
    }
}
