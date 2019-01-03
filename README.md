# cordova-plugin-strict-date

## Descripción

El presente plugin regresa una cadena booleana `"true"` o `"false"` dependiendo de la configuración de la Fecha/Hora del teléfono (si está en modo automático o no).

* Si el teléfono sí tiene la Fecha/Hora en modo automático regresará `"true"`
* Si el teléfono no tiene la Fecha/Hora en modo automático regresará `"false"`

Para realizar una petición al plugin, se debe llamar el método `isAutomaticDateTimeEnabled` el cual pertenece a `StrictDate`. Abajo se puede observar un ejemplo;

```javascript
	StrictDate.isAutomaticDateTimeEnabled(callback);
	
	function callback(response) {
		console.log("Is Automatic Date/Time enabled?: " + response) 
		return response;
	}
```
