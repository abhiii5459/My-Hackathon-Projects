<?php
	require 'dbcon.php';
	if (!$con) {
		echo "Error Connecting DB!";
	}else {
		if (!mysqli_select_db($con, $db)) {
			echo "DB does not exist!";
		} else {
			$bloodGroups = explode(" ", $_REQUEST['bloodGroups']);
			error_log($_REQUEST['bloodGroups']);
			$userNumbers = "";
			$userLocations = "";
			for ($i=0; $i < count($bloodGroups); $i++) { 
				$bloodGroup = $bloodGroups[$i];
				$res = mysqli_query($con, "SELECT phoneNumber, location FROM donors WHERE bloodGroup='$bloodGroup'") or die(mysqli_error($con));
				for ($j=0; $j < mysqli_num_rows($res); $j++) { 
					$user = mysqli_fetch_row($res);
					$userNumbers = $userNumbers.$user[0]." ";
					$userLocations = $userLocations.$user[1]." ";
				}
			}
			$response = json_encode([
	          'phoneNumbers' => substr($userNumbers, 0, -1),
	          'locations' => substr($userLocations, 0, -1)
	        ]);
	        echo $response;
		}
		
	}
?>