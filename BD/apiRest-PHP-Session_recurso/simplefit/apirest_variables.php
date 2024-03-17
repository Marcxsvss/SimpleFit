<?php

	// CONFIGURACIÓN BASE DE DATOS MYSQL
	$servername = "127.0.0.1";
	$username = "root";
	$password = "1234";
	
	// BASE DE DATOS
	$dbname = "simplefit";

	// ACCESO USUARIOS (si está vacío funciona sin usuarios)
	$usuarios = array();
    // $usuarios["juanjo"]="_IesBalmis1";
    // $usuarios["xusa"]="_IesBalmis2";
    // $usuarios["pepe"]="_IesBalmis3";
	
	// TABLAS Y SU CLAVE
	$tablas = array();
	$tablas["alimentos"]="alimentoid";
	$tablas["dietaalimento"]="alimentoid";//Aqui como lo hago??
	$tablas["dietas"]="dietaid";
	$tablas["maquinas"]="maquinaid";
	$tablas["rutinamaquina"]="rutinaid";
	$tablas["rutinas"]="rutinaid";
	$tablas["users"]="dni";
	