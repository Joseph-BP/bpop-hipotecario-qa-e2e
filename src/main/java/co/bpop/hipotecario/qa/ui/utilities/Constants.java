/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.bpop.hipotecario.qa.ui.utilities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String INVALID_URL_MESSAGE = "Invalid URL. Enter a valid value";
    public static final String INVALID_CHANNEL_SALE_MESSAGE = "Invalid channel. Enter a valid value";
    public static final String TITULO_TOOLTIP_PERSONALES = "datos personales";
    public static final String TITULO_TOOLTIP_RIESGOS = "centrales de ";
    public static final String TITULO_GENERACION_OTP = "que revise su celular";
    public static final String TITULO_ACEPTACION_HABEAS_DATA = "Antes de continuar, unas preguntas";
    public static final String TITULO_SEGUNDO_CLIENTE = "segundo cliente";
    public static final String MENSAJE_VALIDACION_DESBORDE = "No se ha desbordado el cliente PEP";
    public static final String MENSAJE_CLIENTE_DESBORDADO = "Se ha desbordado el cliente consultado";
    public static final String TITULO_CLIENTE_DESBORDADO_OTP = "En este momento no fue posible autenticar a tu cliente ";
    public static final String MENSAJE_CLIENTE_DESBORDADO_OTP = "En este momento no fue posible autenticar "+
        "a tu cliente Por favor continúa esta solicitud con el proceso tradicional.";
    public static final String TITULO_CLIENTE_DESBORDADO_GEN_OTP = "Lo sentimos, has excedido el límite";
    public static final String MENSAJE_CLIENTE_DESBORDADO_GEN_OTP = "Lo sentimos, has excedido el límite de "+
        "intentos para generar o validar el código Por favor continúa esta solicitud por el proceso tradicional.";
    public static final String TITULO_CLIENTE_DESBORDADO_ER_TEC = "Algo no salió bien";
    public static final String MENSAJE_CLIENTE_DESBORDADO_ER_TEC = "En estos momentos tenemos inconvenientes técnicos, por favor vuelve a ingresar más tarde.";
    public static final String TITULO_CLIENTE_DESBORDADO_ACTIVIDAD = "proceso tradicional";
    public static final String MENSAJE_CLIENTE_DESBORDADO_ACTIVIDAD = "Realiza esta solicitud por el proceso tradicional "+
        "Debido a la actividad económica";
    public static final String MENSAJE_CLIENTE_DESBORDADO_INACTIVIDAD_T = "Por seguridad cerramos tu sesión";
    public static final String MENSAJE_CLIENTE_DESBORDADO_INACTIVIDAD_COM = "Por seguridad cerramos tu sesión "+
        "Ha pasado mucho tiempo desde tu última actividad en pantalla, deberías ingresar nuevamente.";
    public static final String MENSAJE_CLIENTE_GENDESBORDE = "Esta solicitud no es viable";
    public static final String MENSAJE_CLIENTE_EDADDESBORDE = "Lo sentimos, tu cliente debe tener una edad entre los 18 y 75 años " +
        "Por este motivo no es posible continuar ni atender esta solicitud.";
    public static final String MENSAJE_CLIENTE_EDADDESBORDE_DOS = "Lo sentimos, tu cliente debe tener una edad entre los 18 y 75 años";
    public static final String TIPO_PROYECTO_NUEVO = "Nuevo";
    public static final String TIPO_PROYECTO_USADO = "Usado";
    public static final String TIPO_PROYECTO_DEFINIR = "Por definir";
    public static final String TIPO_CREDITO_LEASING = "4";
    public static final String TIPO_CREDITO_HIPOTECARIO = "3";
    public static final String MENSAJE_FINAL_PREABPROBACION = "Felicitaciones";
    public static final String MENSAJE_DESBORDE_CLIENTE_UNO = "Tu cliente es cliente PEP, por este motivo deberá continuar su solicitud desde cualquier oficina del Banco.";
    public static final String MENSAJE_DESBORDE_CLIENTE_DOS = "es cliente PEP, por este motivo no podrán sumar ingresos y deberán continuar su solicitud desde cualquier oficina del Banco.";
    public static final String MENSAJE_DESBORDE_CLIENTE_DOS_SUMA = "Estamos a un paso para evaluar la pre aprobación";
    public static final String MENSAJE_DESBORDE_CLIENTE_DOS_INICIAL = "Para empezar identifica a tu cliente";
    public static final String TITULO_TOOLTIP_TASA = "Tasa Efectiva Anual (EA):";
    public static final String TITULO_TOOLTIP_USO = "Residencial:";
    public static final String NOT_PREAPPROVAL_MESSAGE = "Lo sentimos, evaluamos esta solicitud de financiación y no ha sido pre aprobada.";

    // New Variables
    public static final String LT_API_HUB = "@api.lambdatest.com/automation/api/v1/sessions/";
    public static final String LT_KEY = "farm.lt.accessKey";
    public static final String LT_USER = "farm.lt.username";
    public static final String LT_GRID = "farm.lt.grid";
    public static final String STATUS_COMPLETE = "completed";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_PASSED = "passed";
    public static final String PROTOCOL_HTTPS = "https://";
    public static final String PROTOCOL_HTTP = "http://";
    public static final String LT_WORD_USER = "user";
    public static final String LT_TUNNEL = "tunnelName";
    public static final String LT_WORD_KEY = "key";
    public static final String LT_OPTION = "LT:Options";
    public static final String FARM_DEVICES = "farm.typeDevice";
    public static final String TYPE_DEVICES = "WebDriver";
    public static final String PROJECT = "bpop_hipotecario_";

}
