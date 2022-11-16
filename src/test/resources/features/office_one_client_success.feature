# language: es

Característica: Adquisición de crédito hipotecario por segmento oficina validando proceso de ODM, AML y OTP por dos clientes


  @Creacion_Link_Autenticacion
  Escenario: Flujo exitoso para generar link con token a aplicacion hipotecario

    Dado que deseo generar link de acceso a hipotecario

  @Flujo_cliente_uno @E2E
  Esquema del escenario: Flujo exitoso para cliente uno por canal oficina

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      | <proyecto> |
    Y ingresa el numero de identificacion del cliente
      | <documento> |
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <correo> | <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena informacion de ingresos
      | <actividad> | <contrato> | <afiliacionPorvenir> | <convenio> | <casaya> |
    Y llena informacion de inmueble
      | <estado> | <proyecto> | <usoInmueble> | <ciudadinmueble> | <valor> | <tipoInmueble> | <subsidio> | <credito> | <tipoMonto> | <montoInmueble> | <plazo> | <tasaEfectiva> | <amortizacion> |
    Entonces valida o envia preaprobacion
      | <correo> |

    Ejemplos:

      | nombres | primer_apellido | segundo_apellido | documento | fecha_nacimiento | cliente_pep | numero     | correo             | solicitudOTP | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | actividad  | contrato | afiliacionPorvenir | convenio | casaya | estado | proyecto | usoInmueble | ciudadinmueble | valor     | tipoInmueble | subsidio             | credito     | tipoMonto  | montoInmueble | plazo | tasaEfectiva | amortizacion |
      | Andres  | Aranguren       |                  | 80737272  | 26-Febrero-1983  | No          | 3175176690 | vjrfraz@gmail.com | No           | No               | 12345 | No                          |          |         |        |       |      |        |        | No           |            | Pensionado |          | No                 | Ninguno  | No     | Nuevo  | Babel    | Residencial | Bogota         | 135000000 | VIS          | No requiere subsidio | hipotecario | porcentaje | 80            | 20    | 12.70        | Pesos        |
     #| Jorge  | Castillo       |                  | 1049603463  | 26-Mayo-1986  | No          | 3005271795 | No           | No               | 12345 | No                          |          |         |        |       |      |        |        | No           |            | Empleado |   Indefinido       | No                 | Ninguno  | Nuevo  | Babel    | Residencial | Bogota         | 150000000 | VIS          | No requiere subsidio| hipotecario | porcentaje | 80            | 17           | 15    | Pesos        | jorge.castillo@avaldigitallabs.com |

  @Flujo_cliente_uno_y_dos @E2E
  Esquema del escenario: Flujo exitoso para cliente uno y dos por canal oficina

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      |<proyecto>|
    Y ingresa el numero de identificacion del cliente
      | <documento> |
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <correo>| <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |<OTPreal>|
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena el formulario de autenticacion cliente
      | <nombres2> | <primer_apellido2> | <segundo_apellido2> | <documento2> | <fecha_nacimiento2> | <numero2> | <correo> | <cliente_pep2> |
    Y solicita OTP nuevo
      | <solicitudOTP> |
    Y selecciona opciones en Sarlaft
      | <residente_fiscal2> | <tin2> | <operaciones_internacionales2> | <producto2> | <entidad2> | <moneda2> | <monto2> | <pais2> | <ciudad2> | <cuenta2> |
    Y llena informacion de ingresos
      | <actividad> | <contrato> | <afiliacionPorvenir> | <convenio> |<casaya>|
    Y llena informacion de ingresos
    | <actividad2> | <contrato2> |  <afiliacionPorvenir2> | <convenio2> |<casaya2>|
    Y llena informacion de inmueble
      | <estado> | <proyecto> | <usoInmueble> | <ciudadinmueble> | <valor> | <tipoInmueble> | <subsidio> | <credito> | <tipoMonto> | <montoInmueble> | <plazo> | <tasaEfectiva> | <amortizacion> |
    Entonces valida o envia preaprobacion
      |<correo>|


    Ejemplos:
      | nombres   | primer_apellido | segundo_apellido| documento  | fecha_nacimiento | cliente_pep | numero     | correo                             | solicitudOTP | OTPreal | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | nombres2 | primer_apellido2 | segundo_apellido2 | documento2 | fecha_nacimiento2 | numero2    | cliente_pep2 | residente_fiscal2 | tin2 | operaciones_internacionales2 | producto2 | entidad2 | moneda2 | monto2 | pais2 | ciudad2 | cuenta2 | actividad  | contrato |  afiliacionPorvenir | convenio   |casaya | actividad2 | contrato2 | afiliacionPorvenir2 | convenio2 |casaya2| estado | proyecto | usoInmueble | ciudadinmueble | valor     | tipoInmueble | subsidio            | credito     | tipoMonto  | montoInmueble | plazo | tasaEfectiva | amortizacion |
      #| Cristhian | Carreno         | Garzon           | 1070011707 | 30-Mayo-1985     | No          | 3000000001 | No           | No      | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Luis     | Canchon          | Gomez             | 1070011708 | 29-Abril-1998     | 3000000002 | No           | No                |      | No                           |           |          |         |        |       |         |         | Pensionado |          | No                 | Ninguno     | No|Pensionado |           | No                  | Honor     | Nuevo  | Babel    | Residencial | Bogota         | 172000000 | VIS          | No requiere subsidio | hipotecario | porcentaje | 70            | 10           | 15    | Pesos        | jorge.castillo@avaldigitallabs.com |
      | Andres    | Aranguren       |                 | 80737272   | 26-Febrero-1985  | No          | 3175176690 | vjrfraz@gmail.com                  | No           | No      | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Hebert    | Medelo          |                   | 1090413042 | 01-Enero-1990     | 3176429593 | No           | No                |      | No                           |           |          |         |        |       |         |         | Pensionado |          | No                  | Ninguno     |  No  | Pensionado |           | No                  | Ninguno   |   No  | Nuevo  | Babel    | Residencial | Bogota         | 135000000 | VIS          | No requiere subsidio| hipotecario | porcentaje | 80            | 15    | 12.70        | Pesos        |
      #| Hebert    | Medelo       |                 | 1090413042    | 01-Enero-1990  | No          | 3176429593 | No           | No      | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Luz | Latorre         |            | CC1030647129 | 30-Mayo-1985     | 3009999999 | No           | No                |      | No                           |           |          |         |        |       |         |         | Pensionado |          | No                 | Ninguno     | Pensionado | No |         | No                  | Ninguno     | Nuevo  | Babel    | Residencial | Bogota         | 135000000 | VIS          | No requiere subsidio| hipotecario | porcentaje | 80            | 15    | 12.07           | Pesos        | jorge.castillo@avaldigitallabs.com |

  @Flujo_cliente_uno_fallo_generacion_otp @E2E
  Esquema del escenario: Flujo exitoso para cliente uno por canal oficina cuando falla generación de OTP

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      | <proyecto> |
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <correo> | <cliente_pep> |
    Y falla generacion OTP
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena informacion de ingresos
      | <actividad> | <contrato> | <afiliacionPorvenir> | <convenio> |
    Y llena informacion de inmueble
      | <estado> | <proyecto> | <usoInmueble> | <ciudadinmueble> | <valor> | <tipoInmueble> | <subsidio> | <credito> | <tipoMonto> | <montoInmueble> | <plazo> | <tasaEfectiva> | <amortizacion> |
    Entonces valida o envia preaprobacion
      |<correo>|

    Ejemplos:
      | nombres | primer_apellido | segundo_apellido | documento   | fecha_nacimiento | cliente_pep | numero     | correo                             | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | actividad  | contrato | afiliacionPorvenir | convenio | estado | proyecto | usoInmueble | ciudadinmueble | valor     | tipoInmueble | subsidio            | credito     | tipoMonto  | montoInmueble |  plazo |tasaEfectiva | amortizacion |
      | Andres  | Aranguren       |                  | 80736235  | 26-Febrero-1983  | No          | 3200000001 | vjrfraz@gmail.com                  |No               | 12345 | No                          |          |         |        |       |      |        |        | No           |            | Pensionado |          | No                 | Ninguno  | Nuevo  | Babel    | Residencial | Bogota         | 135000000 | VIS          | No requiere subsidio| hipotecario | porcentaje | 80            | 20     | 12.07       | Pesos        |




  @Flujo_cliente_uno_y_dos_fallo_generacion_otp @E2E
  Esquema del escenario: Flujo exitoso para cliente uno y dos por canal oficina cuando falla generación OTP Cliente 2

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      |<proyecto>|
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |<OTPreal>|
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena el formulario de autenticacion cliente
      | <nombres2> | <primer_apellido2> | <segundo_apellido2> | <documento2> | <fecha_nacimiento2> | <numero2> | <cliente_pep2> |
    Y falla generacion OTP
    Y selecciona opciones en Sarlaft
      | <residente_fiscal2> | <tin2> | <operaciones_internacionales2> | <producto2> | <entidad2> | <moneda2> | <monto2> | <pais2> | <ciudad2> | <cuenta2> |
    Y llena informacion de ingresos
      | <actividad> | <contrato> | <afiliacionPorvenir> | <convenio> |
    Y llena informacion de ingresos
      | <actividad2> | <contrato2> |  <afiliacionPorvenir2> | <convenio2> |
    Y llena informacion de inmueble
      | <estado> | <proyecto> | <usoInmueble> | <ciudadinmueble> | <valor> | <tipoInmueble> | <subsidio> | <credito> | <tipoMonto> | <montoInmueble> | <plazo> | <tasaEfectiva> | <amortizacion> |
    Entonces valida o envia preaprobacion
      |<correo>|


    Ejemplos:
      | nombres   | primer_apellido | segundo_apellido| documento  | fecha_nacimiento | cliente_pep | numero     | solicitudOTP | OTPreal | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | nombres2 | primer_apellido2 | segundo_apellido2 | documento2 | fecha_nacimiento2 | numero2    | cliente_pep2 | residente_fiscal2 | tin2 | operaciones_internacionales2 | producto2 | entidad2 | moneda2 | monto2 | pais2 | ciudad2 | cuenta2 | actividad  | contrato |  afiliacionPorvenir | convenio    | actividad2 | contrato2 | afiliacionPorvenir2 | convenio2 | estado | proyecto | usoInmueble | ciudadinmueble | valor     | tipoInmueble | subsidio             | credito     | tipoMonto  | montoInmueble | plazo | tasaEfectiva | amortizacion | correo                             |
      | Andres    | Aranguren       |                 | 1049000000 | 26-Febrero-1985  | No          | 3175176690 | No           | No      | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Hebert    | Medelo       |                 | 1049000001    | 01-Enero-1990  | 3200000001 | No           | No                |      | No                           |           |          |         |        |       |         |         | Pensionado |          | No                 | Ninguno     | Pensionado |           | No                  | Ninguno     | Nuevo  | Babel    | Residencial | Bogota         | 135000000 | VIS          | No requiere subsidio| hipotecario | porcentaje | 80            | 15    | 12.07           | Pesos        | jorge.castillo@avaldigitallabs.com |



  @Flujo_cliente_uno_fallo_validacion_otp @E2E
  Esquema del escenario: Flujo exitoso para cliente uno por canal oficina, cuando falla la validación de OTP

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      | <proyecto> |
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Y falla validacion OTP
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena informacion de ingresos
      | <actividad> | <contrato> | <afiliacionPorvenir> | <convenio> |
    Y llena informacion de inmueble
      | <estado> | <proyecto> | <usoInmueble> | <ciudadinmueble> | <valor> | <tipoInmueble> | <subsidio> | <credito> | <tipoMonto> | <montoInmueble> | <plazo> | <tasaEfectiva> | <amortizacion> |
    Entonces valida o envia preaprobacion
      |<correo>|

    Ejemplos:
      | nombres | primer_apellido | segundo_apellido | documento  | fecha_nacimiento | cliente_pep | numero     | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | actividad  | contrato | afiliacionPorvenir | convenio | estado | proyecto | usoInmueble | ciudadinmueble | valor     | tipoInmueble | subsidio            | credito     | tipoMonto  | montoInmueble |  plazo |tasaEfectiva | amortizacion | correo                             |
      | Andres  | Aranguren       |                  | 3200000002 | 26-Febrero-1983  | No          | 3175176690 | No               | 12345 | No                          |          |         |        |       |      |        |        | No           |            | Pensionado |          | No                 | Ninguno  | Nuevo  | Babel    | Residencial | Bogota         | 135000000 | VIS          | No requiere subsidio| hipotecario | porcentaje | 80            | 20    | 12.07           | Pesos        | jorge.castillo@avaldigitallabs.com |


  @Flujo_cliente_uno_y_dos_fallo_validacion_otp @E2E
  Esquema del escenario: Flujo exitoso para cliente uno y dos por canal oficina cuando falla validación OTP Cliente 2

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      |<proyecto>|
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |<OTPreal>|
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena el formulario de autenticacion cliente
      | <nombres2> | <primer_apellido2> | <segundo_apellido2> | <documento2> | <fecha_nacimiento2> | <numero2> | <cliente_pep2> |
    Y falla validacion OTP
    Y selecciona opciones en Sarlaft
      | <residente_fiscal2> | <tin2> | <operaciones_internacionales2> | <producto2> | <entidad2> | <moneda2> | <monto2> | <pais2> | <ciudad2> | <cuenta2> |
    Y llena informacion de ingresos
      | <actividad> | <contrato> | <afiliacionPorvenir> | <convenio> |
    Y llena informacion de ingresos
      | <actividad2> | <contrato2> |  <afiliacionPorvenir2> | <convenio2> |
    Y llena informacion de inmueble
      | <estado> | <proyecto> | <usoInmueble> | <ciudadinmueble> | <valor> | <tipoInmueble> | <subsidio> | <credito> | <tipoMonto> | <montoInmueble> | <plazo> | <tasaEfectiva> | <amortizacion> |
    Entonces valida o envia preaprobacion
      |<correo>|


    Ejemplos:
      | nombres   | primer_apellido | segundo_apellido | documento   | fecha_nacimiento | cliente_pep | numero     | solicitudOTP | OTPreal | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | nombres2 | primer_apellido2 | segundo_apellido2 | documento2 | fecha_nacimiento2 | numero2    | cliente_pep2 | residente_fiscal2 | tin2 | operaciones_internacionales2 | producto2 | entidad2 | moneda2 | monto2 | pais2 | ciudad2 | cuenta2 | actividad  | contrato |  afiliacionPorvenir| convenio    | actividad2 | contrato2 | afiliacionPorvenir2 | convenio2 | estado | proyecto | usoInmueble | ciudadinmueble | valor     | tipoInmueble | subsidio            | credito     | tipoMonto  | montoInmueble | plazo | tasaEfectiva | amortizacion | correo                             |
      | Andres    | Aranguren       |                  | 1049000000  | 26-Febrero-1985  | No          | 3175176690 | No           | No      | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Hebert   | Medelo           |                   | 3200000002 | 01-Enero-1990     | 3176429593 | No           | No                |      | No                           |           |          |         |        |       |         |         | Pensionado |          | No                 | Ninguno     | Pensionado |           | No                  | Ninguno   | Nuevo  | Babel    | Residencial | Bogota         | 135000000 | VIS          | No requiere subsidio| hipotecario | porcentaje | 80            | 15    | 12.07        | Pesos        | jorge.castillo@avaldigitallabs.com |





  @Flujo_desborde_error_tecnico_y_validacion_otp
  Esquema del escenario: Flujo exitoso desborde error tecnico para cliente uno por canal oficina con mock

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      |<proyecto>|
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |
    Entonces sera desbordado

    Ejemplos:
      | proyecto | nombres | primer_apellido | segundo_apellido | documento  | fecha_nacimiento | cliente_pep | numero     | solicitudOTP |
      #|     | Maria   | Perez           | Julio            | 1070011707 | 28-Junio-1992    | No          | 3507742337 | No           |
      |     | Andres   | Aranguren           |             | 80736235 | 26-Febrero-1985    | No          | 3175176690 | No           |


  @Flujo_desborde @E2E
  Esquema del escenario: Flujo exitoso desborde general para cliente uno por canal oficina

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      |<proyecto>|
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Entonces sera desbordado

    Ejemplos:
      | proyecto | nombres | primer_apellido | segundo_apellido | documento  | fecha_nacimiento | cliente_pep | numero     |
      |     | Maria   | Perez           | Lujan            | 728594048  | 28-Junio-2010    | No          | 3507742332 |
      |     | Maria   | Perez           | Ramirez          | 728594048  | 28-Junio-1930    | No          | 3507742332 |
      |     | Maria   | Perez           | Julio            | 728594048  | 28-Junio-1992    | Si          | 3507742332 |
      |         | Maria   | Perez           | Julio            | 1070011707 | 28-Junio-1992    | No          | 3507742332 |

  @Flujo_desborde_dos_general @E2E
  Esquema del escenario: Flujo exitoso desborde general para cliente dos por canal oficina

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      |<proyecto>|
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena el formulario de autenticacion cliente
      | <nombres2> | <primer_apellido2> | <segundo_apellido2> | <documento2> | <fecha_nacimiento2> | <numero2> | <cliente_pep2> |
    Y valida continuación con o sin ingresos
      |<Desicion>|
    Entonces verifica comportamiento desborde hasta pagina principal

    Ejemplos:
      | proyecto | nombres   | primer_apellido | segundo_apellido | documento | fecha_nacimiento | cliente_pep | numero     | solicitudOTP | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | nombres2 | primer_apellido2 | segundo_apellido2 | documento2 | fecha_nacimiento2 | numero2    | cliente_pep2 | Desicion |
      |     | Cristhian | Carreño         | Garzon           | 80881312  | 30-Mayo-1990     | No          | 3013374238 | No           | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Luis     | ramirez          | Julio             | 26248702   | 29-Abril-2015     | 3507742332 | No           | No       |
      |     | Cristhian | Carreño         | Garzon           | 80881312  | 30-Mayo-1985     | No          | 3013374238 | No           | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Luis     | Canchon          |                   | 1070011708 | 29-Abril-1942     | 3143569878 | No           | No       |
      |       | Cristhian | Carreño         | Garzon           | 80881312  | 30-Mayo-1985     | No          | 3013374238 | No           | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Luis     | Canchon          |                   | 1070011708 | 29-Abril-1998     | 3143569878 | Si           | No       |

  @Flujo_desborde_operadores @Operadores
  Esquema del escenario: Flujo exitoso desborde operadores para cliente uno por canal oficina

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      |<proyecto>|
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena informacion de ingresos
      | <actividad> | <contrato> | <afiliacionPorvenir> | <convenio> |<casaya>|
    Entonces sera desbordado

    Ejemplos:
      | proyecto | nombres          | primer_apellido | segundo_apellido | documento  | fecha_nacimiento | cliente_pep | numero     | solicitudOTP | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | actividad  | contrato | afiliacionPorvenir | convenio |casaya|
      |          | Cristhian Camilo | Carreño         | Garzon           | 1070011709 | 30-Mayo-1985     | No          | 3005271795 | No           | No               | 12345 | No                          |          |         |        |       |      |        |        | No           |            | Pensionado |          | No                 | Ninguno        |No|

  @Flujo_desborde_dos_operadores @Operadores
  Esquema del escenario: Flujo exitoso desborde operadores para cliente dos por canal oficina

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN SALA DE VENTAS
    |<proyecto>|
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |
    Y selecciona opciones en Sarlaft
      | <residente_fiscal> | <tin> | <operaciones_internacionales> | <producto> | <entidad> | <moneda> | <monto> | <pais> | <ciudad> | <cuenta> |
    Y adicionara ingresos adicionales
      | <sumaIngresos> | <parentesco> |
    Y llena el formulario de autenticacion cliente
      | <nombres2> | <primer_apellido2> | <segundo_apellido2> | <documento2> | <fecha_nacimiento2> | <numero2> | <cliente_pep2> |
    Y solicita OTP nuevo
      | <solicitudOTP> |
    Y selecciona opciones en Sarlaft
      | <residente_fiscal2> | <tin2> | <operaciones_internacionales2> | <producto2> | <entidad2> | <moneda2> | <monto2> | <pais2> | <ciudad2> | <cuenta2> |
    Y llena informacion de ingresos
      | <actividad> | <contrato> | <afiliacionPorvenir> | <convenio> |<casaya>|
    Y llena informacion de ingresos
      | <actividad2> | <contrato2> | <afiliacionPorvenir2> | <convenio2> |<casaya2>|
    Y valida continuación con o sin ingresos
      |<Desicion>|
    Entonces verifica comportamiento desborde hasta pagina principal

    Ejemplos:
      | proyecto | nombres   | primer_apellido | segundo_apellido | documento  | fecha_nacimiento | cliente_pep | numero     | solicitudOTP | residente_fiscal | tin   | operaciones_internacionales | producto | entidad | moneda | monto | pais | ciudad | cuenta | sumaIngresos | parentesco | nombres2    | primer_apellido2 | segundo_apellido2 | documento2 | fecha_nacimiento2 | numero2    | cliente_pep2 | residente_fiscal2 | tin2 | operaciones_internacionales2 | producto2 | entidad2 | moneda2 | monto2 | pais2 | ciudad2 | cuenta2 | actividad  | contrato | afiliacionPorvenir | convenio |casaya| actividad2 | contrato2  | afiliacionPorvenir2 | convenio2 |casaya2| Desicion |
      | Babel    | Cristhian | Carreño         | Garzon           | 1070011708 | 30-Mayo-1985     | No          | 3013374238 | No           | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Luis Fernando | Canchon          | Gomez             | 1070011709 | 29-Abril-1992     | 3143569878 | No           | No                | 123  | No                           |           |          |         |        |       |         |         | Pensionado |          | No                 | Ninguno |No | Empleado   | fijo       | No                  | Ninguno     |No| Si       |
      | Babel    | Cristhian | Carreño         | Garzon           | 1070011708 | 30-Mayo-1985     | No          | 3013374238 | No           | No               | 12345 | No                          |          |         |        |       |      |        |        | Si           | Yerno      | Luis Andres | Canchon          | Jimenez           | 1070011709 | 29-Abril-1992     | 3143569878 | No           | No                | 123  | No                           |           |          |         |        |       |         |         | Pensionado |          | No                 | Ninguno  | No |Empleado   | Indefinido | No                  | Ninguno      |No| No       |


  @Flujo_inactividad_sesion
  Esquema del escenario: Flujo exitoso para sesion perdida por inactividad de tiempo

    Dado Que Orlando es un asesor de ventas del banco popular
    Cuando Orlando selecciona el segmento de venta EN OFICINA
      |<proyecto>|
    Y llena el formulario de autenticacion cliente
      | <nombres> | <primer_apellido> | <segundo_apellido> | <documento> | <fecha_nacimiento> | <numero> | <cliente_pep> |
    Y solicita OTP nuevo
      | <solicitudOTP> |
    Y espera 5 minutos
    Entonces sera desbordado

    Ejemplos:
      | proyecto | nombres   | primer_apellido | segundo_apellido | documento | fecha_nacimiento | cliente_pep | numero     | solicitudOTP |
      |     | Cristhian | Carreño         | Garzon           | 80881312  | 30-Mayo-1985     | No          | 3013374238 | No           |

