package com.falabella.product.exceptions;

public class RequestException  extends RuntimeException {

   private static final String CHECK_INFO = "Error al ejecutar la solicitud, revise los datos ingresados";
   public Object getMessageError() {
      return CHECK_INFO;
   }
}
