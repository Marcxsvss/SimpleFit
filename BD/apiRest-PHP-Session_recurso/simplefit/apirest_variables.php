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
	$tablas["maquinas"]="maquinaid";
	$tablas["rutinamaquina"] = array("rutinaid", "maquinaid");
	$tablas["rutinas"]="rutinaid";
	$tablas["usuarios"]="dni";
	$tablas["usuariorutina"]=array("rutinaid", "userid");
	$tablas["consejos"]="consejoid";
	