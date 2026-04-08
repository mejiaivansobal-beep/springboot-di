package com.mejia.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
// Le dice a Spring: "Ojea esta clase, porque aquí hay instrucciones de cómo quieres que configure el proyecto"
@Configuration
// Spring: "Además de los archivos de siempre, ve y lee este archivo llamado config.properties que está en la carpeta resources"
@PropertySource("classpath:config.properties")

// sta clase es el centro de mando de las configuraciones personalizadas de la apliacion.
public class AppConfig {
    /*
    Sin esta clase, Spring no sabría que este archivo existe y, por lo tanto,
    el Environment no encontraría el valor 1.25d.
     */
}
