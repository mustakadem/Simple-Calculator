**************Error: Mantener número cuando se pulsa operación***************

-Arreglo este error quitando el seteo de la pantalla en la funcion applyOp.
- Asigno en la funcion applyOp un atributo de clase Booleano 'pulsado' a true.
-En la funcion readNumber, hay una sentecia selectiva que comprueba si 
'pulsado' es true,si es verdad setea la pantalla a cadenas vacias.
 


*************Error: No se pueden escribir número con decimales*************

Al if de la funcion readNumber le faltaba una respuesta a la hora de que readNumber tenga valor false.



*************Error: Borrado de cifras decimales********************

Para resolver este error he usado la sentencia:  
	resultTextView.setText(resultTextView.getText().subSequence(0, resultTextView.getText().length() - 1) + "");
Con subSequence pongo e indice de inicio y el indice final.



*************Error: Comportamiento botón igual*****************
-Declaro una variable de clase 'controlador' de tipo numerico y 'pulsarIgual' de tipo booleana y a inicializo a false.
-hago una condicion selectiva y si 'pulsarIgual' es false,'secondNumber' signa su valor a 'controlador'.
-hago otra condicion selectiva y si 'pulsarIgual' es true, 'controlador' signa su valor a 'mAccumulator'.

En el switch cada vez que entra en un case 'pulsarIgual' se inicializa a true.


*******extra******
Por si sube nota tambien e cambiado la funcion changeSign, quitando la condicion selectiva 
y asignando a 'actualNumber' el valor de la multiplicacion entre 'actualNumber' y -1

