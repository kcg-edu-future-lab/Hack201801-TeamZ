<?php 
require_once('function.php');

$tablename = (isset($_POST["tablename"])) ? $_POST["tablename"] : "";

echo $tablename;

mb_language("uni");
mb_internal_encoding("utf-8");
mb_http_input("auto");
mb_http_output("utf-8");

$dbh = connectDb();

if($tablename == "user"){
	$username = $_POST['username'];
	$position = $_POST['position'];
	$mail = $_POST['mail'];
	$point = $_POST['point'];
	$sth = $dbh->prepare("INSERT INTO user (username, position, mail, point) VALUES(:username, :position, :mail, :point);");
	$sth->execute(array(":username" => $username, ":position" => $position, ":mail" => $mail, ":point" => $point));
}
else if($tablename == "member"){
	$number = $_POST['number'];
	$username = $_POST['username'];
	$sth = $dbh->prepare("INSERT INTO member (number, username) VALUES(:number, :username);");
	$sth->execute(array(":number" => $number, ":username" => $username));
}
else if($tablename == "help"){
	$username = $_POST['username'];
	$date = $_POST['date'];
	$sth = $dbh->prepare("INSERT INTO help (username, date) VALUES(:username, :date);");
	$sth->execute(array(":username" => $username, ":date" => $date));
}
else if($tablename == "schedule"){
	$sdate = $_POST['sdate'];
	$edate = $_POST['edate'];
	$number = $_POST['number'];
	$free = $_POST['free'];
	echo($sdate.$edate.$number.$free);
	$sth = $dbh->prepare("INSERT INTO schedule (sdate, edate, number, free) VALUES(:sdate, :edate, :number, :free);");
	$sth->execute(array(":sdate" => $sdate, ":edate" => $edate, ":number" => $number, ":free" => $free));
}
header('Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept');
header("Access-Control-Allow-Origin: *");
?>