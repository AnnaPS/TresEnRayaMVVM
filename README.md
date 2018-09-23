# TresEnRayaMVVM

Juego para dos personas basado en el tres en raya. Desarrollado para Android con el patron MVVM (Model-View - ViewModel)y DataBinding.
### 2 JUGADORES
- Jugador 1: X
- Jugador 2: O
  
 ## CAPTURAS DE LA APLICACIÓN
![1](https://user-images.githubusercontent.com/13244085/45930410-44647500-bf60-11e8-9d0d-0b89692dd231.JPG)
![2](https://user-images.githubusercontent.com/13244085/45930412-50503700-bf60-11e8-8ea7-0d63cb700c1b.JPG)
![3](https://user-images.githubusercontent.com/13244085/45930414-52b29100-bf60-11e8-93ee-cb9d14b3fb7b.JPG)

## LIBRERIAS USADAS
- **DataBinding**
- **LiveData**
- **ViewModel**

## DEPENDENCIAS NECESARIAS
Es necesario importar las dependecias para utilizar ViewModel en el archivo build.gradle (Module.app) 

```
implementation "android.arch.lifecycle:extensions:1.1.0"
implementation "android.arch.lifecycle:viewmodel:1.1.0"

```

## HABILITAR DATABINDING
Para habilitar data binding es necesario añadir las siguientes lineas en build.gradle(Module.app) dentro de android{}
```
  dataBinding {
      enabled = true
 }
```
## DEPENDENCIAS DISEÑO (GRIDLAYOUT Y MATERIAL DESIGN)
```
implementation 'com.android.support:gridlayout-v7:27.1.1'
implementation 'com.android.support:design:27.1.1'
```

:+1: Por favor si existe algún bug, crear un issue. 

