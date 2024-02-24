# Eshop
Nama: Muhammad Nanda Pratama<br>
Kelas: Adpro A <br>
NPM: 2206081654
<hr>

<h1>TUTORIAL 1</h1>

<h3>Reflection 1</h3>

Setelah saya mengerjakan Exercise 1 ini, saya banyak mengenali fitur-fitur yang terdapat pada Spring Boot, di antaranya adalah postMapping dan getMapping.
Saya pun juga mempelajari bagaimana cara membuat edit-product dan delete-product pada tutorial 1 ini.<br>

Saya juga menerapkan beberapa prinsip dari _clean code_ supaya kode saya dapat mudah dipahami oleh
_programmer_ lainnya. Konsep _clean code_ yang saya terapkan di antaranya adalah penggunaan nama variabel yang
_meaningful_, meminimalisir penggunaan _comment_, dan penamaan _function_ yang _meaningful_.<br>

Untuk bagian _secure coding_, saya baru ingin melakukan implementasi _access control_ untuk POST dan DELETE.  <br>


<h3>Reflection 2</h3>

1. Setelah saya membuat unit test, saya lebih bisa memverifikasi kebenaran pada kode saya, sehingga dapat membantu mengatasi jika terjadi kesalahan kode dan mempermudah mengatasinya.
2. Meskipun kode kita memiliki 100% code coverage, bukan berarti kode kita sudah dipastikan terbebas dari _bug_ dan _error_, karena bisa saja terdapat _bug_ yang sulit dideteksi sehingga _unit test_ tidak memverifikasi hal tersebut.
3. Saya mempelajari banyak hal ketika membuat Functional Test, terutama pada Selenium WebDriver, terutama mengenai interaksi elemen-elemen pada halaman _web_.


<h1>TUTORIAL 2</h1>

<h3>Jawaban nomor 1</h3>

1. - Memperbaiki masalah executable permission issue pada Dockerfile dengan menggunakan perintah chmod +x gradlew
-  Mengatur konfigurasi pada Github Actions Workflow untuk SonarCould.
- Menghapus access modifier public pada setiap class yang berhubungan dengan test.

2. Menurut saya, implementasi workflow saya sudah memenuhi definisi CI/CD. Salah satu buktinya adalah adanya file ci.yml yang digunakan untuk melakukan test ketika melakukan push dan pull req di branch. Selanjutnya, jika test berhasil, kode akan dideploy ke aplikasi deploy. Saya sendiri menggunakan aplikasi deploy Koyeb.

<h1>TUTORIAL 3</h1>

1) Explain what principles you apply to your project!
Jawaban: - Saya mengimplementasikan Single Responsibility Principle (SRP) dengan memisahkan Car dari ProductController menjadi dua file, yaitu CarController dan ProductController.
- Pada Open-Closed Principle (OCP), saya sudah melakukannya ketika membuat package repository dan service. Pada class CarController, CarService menggunakan interface, bukan menggunakan class seperti CarServiceImpl.
- Pada Liskov substitution principle (LSP), saya tidak perlu melakukan inheritance pada CarController dengan ProductController, karena sudah ada interface CarService.
- Pada Interface segregation principle (ISP), saya menerapkannya dengan memisahkan CarServiceImpl dan ProductServiceImpl, yang mana tiap dari kedua file tersebut sudah diimplementasikan dari interface yang sudah ada untuk kedua file tersebut.
- Pada Dependency inversion principle (DIP), saya menerapkannya dengan membuat interface ProductService dan CarService, kemudian menggunakannya sebagai atribut di file java yang berbeda.

2) Explain the advantages of applying SOLID principles to your project with examples.
Jawaban: Keuntungan dari menerapkan SOLID principles ini adalah mempermudah dalam maintain kode saya. Kemudian kode saya juga lebih terskruktur, rapi, dan lebih scalable.

3) Explain the disadvantages of not applying SOLID principles to your project with examples.
Jawaban: Tidak menerapkan SOLID principles dapat menyebabkan kesulitan pada kode kita karena lebih sulit di maintain. Sebagai contoh, ketika kita tidak mematuhi prinsip Single Responsibility Principle (SRP), file-file kelas Java menjadi semakin kompleks dan sulit untuk diatasi saat terjadi masalah. Misalnya, jika kita mengalami masalah terkait dengan objek 'Car', kita harus menyunting satu file ProductController yang mungkin juga menangani entitas lain. Hal ini dapat menyebabkan kesulitan dalam mengidentifikasi dan memperbaiki masalah yang bersifat spesifik pada 'Car', karena kita harus berhati-hati agar perubahan yang kita lakukan tidak berdampak negatif pada bagian lain yang tidak terkait dengan 'Car'.


