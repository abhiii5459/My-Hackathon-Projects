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
			if (!isset($form_orgId) || !isset($form_phoneNumber)) {
				echo 1;
				return;	
			} else {
				$query = "INSERT INTO su VALUES ('$form_orgId', '$form_phoneNumber', '1')";
				$res = mysqli_query($con, $query);
				if (!$res) {
					echo "There was error while registering".mysqli_error($con);
				} else {
					echo "Registered Successfully with OrgId = $form_orgId and Phone Number = $form_phoneNumber";
				}
				//echo "DB in use : $db";	
			}
		}
		
	}
?>