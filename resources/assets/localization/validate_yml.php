<?php
$exit_code = 0;
$warning = 0;
set_error_handler("warning_handler", E_WARNING);

try {
  $yml_files = glob("/translations/*.yml");

  if (count($yml_files) == 0) {
    echo 'No files found';
    exit(1);
  }

  foreach ($yml_files as $yml_file) {
    $warning = 0;
    echo 'checking file: ', $yml_file, '   --->   ';
    yaml_parse_file($yml_file);
    echo "\n";
  }

  exit($exit_code);
} catch (Exception $e) {
  echo 'Caught exception: ',  $e->getMessage(), "\n";
  $exit_code = 1;
}

function warning_handler($errno, $errstr) { 
  global $exit_code;
  echo 'Caught warning: ', $errstr, "\n";
  $exit_code = 1;
}

?>
