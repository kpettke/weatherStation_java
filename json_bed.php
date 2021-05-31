<?php

require_once 'con_DB.php';

$stmt;
$query;

        $query = ("SELECT * FROM sypialnia ORDER BY data DESC");
        $stmt = $conn->prepare($query);
        $stmt->execute();
        //$tmp_db = $stmt->fetchAll(PDO::FETCH_ASSOC)
       

        $data = array();

 
        foreach ($stmt->fetchAll(PDO::FETCH_ASSOC) as $result)
        {           
        $temp['id'] = $result['id'];
        $temp['temp'] = $result['temp'];
        $temp['hum'] = $result['hum'];
        $temp['data'] = $result['data'];
        array_push($data, $temp);
        }
       echo  $output = json_encode(['sypialnia' => $data])
       // echo json_encode($data);
        //echo $output;


?>