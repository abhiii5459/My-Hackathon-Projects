<?php
	require 'dbcon.php';
	if (!$con) {
		echo "Error Connecting DB!";
	}else {
		if (!mysqli_select_db($con, $db)) {
			echo "DB does not exist!";
		} else {
			extract($_REQUEST, EXTR_PREFIX_ALL, 'form');
			//echo $form_location." ".$form_sex." ".$form_dob." ".$form_phoneNumber." ".$form_bloodGroup;
			if (!isset($form_phoneNumber) || !isset($form_bloodGroup) || !isset($form_sex) || !isset($form_dob) || !isset($form_location)) {
				echo 1;
				return;	
			} else {
				$form_userid = mysqli_num_rows(mysqli_query($con, 'SELECT * FROM donors')) ;
				$query = "INSERT INTO requests VALUES ('$form_phoneNumber', NULL)";
				$res = mysqli_query($con, $query);
				$query = "INSERT INTO donors VALUES ('$form_userid', '$form_phoneNumber', '$form_bloodGroup', '$form_sex', '$form_dob', '$form_location', '1')";
				$res = mysqli_query($con, $query);
				if (!$res) {
					echo "There was error while registering".mysqli_error($con);
				} else {
					echo "Registered Successfully with UserID = $form_userid and Phone Number = $form_phoneNumber";
				}
				//echo "DB in use : $db";	
			}
		}
		
	}
?>