<?php

include("config.php");

$id_berita = $_POST['id_berita'];
$judul_berita = $_POST['judul_berita'];
$waktu_berita = $_POST['waktu_berita'];
$penulis_berita = $_POST['penulis_berita'];
$isi_berita = $_POST['isi_berita'];

$sql = "INSERT INTO berita VALUES ('$id_berita', '$judul_berita', '$waktu_berita', '$penulis_berita', '$isi_berita')";
$query = mysqli_query($db, $sql);
	if ($query) {
		# code...
	}else{
		die("Gagal menyimpan data...");
	}

?>