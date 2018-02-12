<?php
	require 'dbcon.php';
	if (!$con) {
		echo "Error Connecting DB!";
	}else {
		if (!mysqli_select_db($con, $db)) {
			echo "DB does not exist!";
		} else {
			print_r(extract($_REQUEST, EXTR_PREFIX_ALL, 'form'));
			/*if (!isset($form_phoneNumber) || !isset($form_bloodGroup) || isset($form_sex) || !isset($form_dob) || !isset($form_location)) {
				echo 1;
				return;	
			} else {
				$form_userid = mysqli_num_rows(mysqli_query($conn, 'SELECT * FROM donors')) ;
				$query = "INSERT INTO donors VALUES ('$form_userid', '$form_phoneNumber', '$form_bloodGroup', '$form_sex', '$form_dob', '$form_loc', '1')";
				$res = mysqli_query($con, $query);
				if (!$res) {
					echo "There was error while registering".mysql_error();
				} else {
					echo "Registered Successfully with UserID = $form_userid and Phone Number = $form_phoneNumber";
				}
				//echo "DB in use : $db";	
			}*/
		}
		
	}
?>