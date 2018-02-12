<?php
	require 'dbcon.php';
	if (!$con) {
		echo "Error Connecting DB!";
	}else {
		if (!mysqli_select_db($con, $db)) {
			echo "DB does not exist!";
		} else {
			$rawData = substr(file_get_contents('php://input'), 1, -1);
			$rawData = explode(",", $rawData);
			for ($i=0; $i < count($rawData); $i++) { 
				$tuple = explode(" ", $rawData[$i]);
				$res = mysqli_query($con, "SELECT * FROM requests WHERE donorNumber='$tuple[0]'") or die(mysqli_error($con));
				if (mysqli_fetch_row($res)[1] != "NULL" ){
					$reqRes = mysqli_query($con, "UPDATE requests SET orgNumber = '$tuple[1]' WHERE donorNumber='$tuple[0]'") or die(mysqli_error($con));
					echo "Request Generated";
					return;
				} else {
					echo "Request Already Pending";
				}
			}
		}
		
	}
?>