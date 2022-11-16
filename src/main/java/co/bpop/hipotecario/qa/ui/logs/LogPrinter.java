/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.bpop.hipotecario.qa.ui.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogPrinter {

  private static final Logger logger = LoggerFactory.getLogger(LogPrinter.class);

  private LogPrinter() {
    super();
  }

  public static void printLog(final String message) {
    logger.info(message);
  }

  public static void printErrror(final String error) {
    logger.error(error);
  }
}
