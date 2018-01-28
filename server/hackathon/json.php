<?php 
require_once('function.php');

$tablename = (isset($_GET["tablename"])) ? $_GET["tablename"] : "";


mb_language("uni");
mb_internal_encoding("utf-8");
mb_http_input("auto");
mb_http_output("utf-8");

$dbh = connectDb();

$sql = 'select * from '.$tablename;
echo $tablename;
if($tablename == "user"){
	if(isset($_GET["username"])){
		$sth = $dbh->prepare($sql." where username = :username");
		$sth -> execute(array(":username" => $_GET["username"]));
	}
	else if(isset($_GET["position"])){
		$sth = $dbh->prepare($sql." where position = :position");
		$sth -> execute(array(":position" => $_GET["position"]));
	}	
	else{
		$sth = $dbh->prepare($sql);
		$sth -> execute();
	}

	$userData = array();
	while($row = $sth->fetch(PDO::FETCH_ASSOC)){

		$userData[] = array(
			'username'=>$row['username'],
			'position'=>$row['position'],
			'mail'=>$row['mail'],
			'point'=>$row['point']
		);
	}
}
else if($tablename == "member"){
	if(isset($_GET["number"])){
		$sth = $dbh->prepare($sql." where number = :number");
		$sth -> execute(array(":number" => $_GET["number"]));
	}
	else{
		$sth = $dbh->prepare($sql);
		$sth -> execute();
	}
	
	$userData = array();
	
	while($row = $sth->fetch(PDO::FETCH_ASSOC)){
		
		$userData[] = array(
				'number'=>$row['number'],
				'username'=>$row['username'],
		);
	}
}
else if($tablename == "help"){
	if(isset($_GET["date"])){
		$sth = $dbh->prepare($sql." where date = :date");
		$sth -> execute(array(":date" => $_GET["date"]));
	}
	else{
		$sth = $dbh->prepare($sql);
		$sth -> execute();
	}
	
	$userData = array();
	
	while($row = $sth->fetch(PDO::FETCH_ASSOC)){
		
		$userData[] = array(
				'date'=>$row['date'],
				'username'=>$row['username'],
		);
	}
}
else if($tablename == "schedule"){
	if(isset($_GET["number"])){
		$sth = $dbh->prepare($sql." where number = :number");
		$sth -> execute(array(":number" => $_GET["number"]));
	}
	else{
		$sth = $dbh->prepare($sql);
		$sth -> execute();
	}
	
	$userData = array();
	
	while($row = $sth->fetch(PDO::FETCH_ASSOC)){
		
		$userData[] = array(
				'sdate'=>$row['sdate'],
				'edate'=>$row['edate'],
				'number'=>$row['number'],
				'free'=>$row['free'],
		);
	}
}
header('Content-type: application/json');
header('Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept');
header("Access-Control-Allow-Origin: *");
echo json_encode($userData);
?>