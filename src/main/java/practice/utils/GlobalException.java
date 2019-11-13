package practice.utils;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//此注解里并不能使用 requestMapping 所以返回的异常页面方法 单独写进了 baseController
@ControllerAdvice
public class GlobalException {
  /*  @ExceptionHandler(RuntimeException.class)
    public void handleGlobalException(){
        System.err.println("全局异常捕捉");
    }*/
  @ExceptionHandler(RuntimeException.class)
  public String handleGlobalException(Model model,Exception e){
      e.printStackTrace();
      model.addAttribute("error","全局异常处理");
      return "error";
  }
  @Bean
  public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
      return factory -> {
          ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND,"/404");
          factory.addErrorPages(error404);
      };
  }


}
