<?php 
require_once('config.php');

function connectDb(){
	try{
		return new PDO(DNS, DB_USER, DB_PASSWORD);
	} catch(PDOException $e){
		echo $e->getMessage();
		exit;
	}
}
?>