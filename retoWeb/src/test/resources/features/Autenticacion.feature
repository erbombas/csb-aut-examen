#language: es
@Web
Característica: Registro de usuario e inicio de sesión de usuario

Antecedentes:
Dado que me encuentro en la pantalla inicial de Demoblaze

Regla: La prueba debe permitir el ingreso de los siguientes casos

@CA01
Escenario: Registro de usuario
Cuando realizo el registro de un nuevo usuario
Entonces podre ver el siguiente mensaje de la alerta "Sign up successful."

@CA02
Esquema del escenario: Inicio de sesion
Cuando ingreso mis credenciales e ingreso a la plataforma
| Username   | Password   |
| <Username> | <Password> |
Entonces podre ver mi  usuario "<Username>" en la esquina superior derecha
Ejemplos:
  | Username | Password     |
    #Data:src/main/resources/Usuarios.xlsx|E01
|Yilmar|Generico123!|



