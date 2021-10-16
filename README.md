#Exporter app


Aplikasi ini dibuat dengan menggunakan java
untuk menjalankan aplikasi ini laptop anda harus terinstal java minimal versi 1.8

Aplikasi ini telah di test menggunakan sistem operasi windows

Contoh penggunaan :
Download file ```exporter-jar-with-dependencies.jar``` ,
kemuadian di dalam direktory file ```exporter-jar-with-dependencies.jar``` berada, ketikan perintah
dibawah ini untuk menjalan kan pengujian

- Menampilkan help 
    ```java -jar exporter-jar-with-dependencies.jar -h```
- Mengkonversi menjadi file json
    ```java -jar exporter-jar-with-dependencies.jar -f C:\Users\darma\OneDrive\Desktop\sample-log-2.log -t text``` 
- Mengkonversi menjadi file text
    ```java -jar exporter-jar-with-dependencies.jar -f C:\Users\darma\OneDrive\Desktop\sample-log-2.log -t json```
- Jika user tidak memasukan salah satu flag, maka default outputnya adalah PlainText.
    ```java -jar exporter-jar-with-dependencies.jar -f C:\Users\darma\OneDrive\Desktop\sample-log-2.log``` 
-User juga bisa memilih dimana dia akan meletakan file output tersebut. Dengan menggunakan flag -o.
    ```java -jar exporter-jar-with-dependencies.jar -f C:\Users\darma\OneDrive\Desktop\sample-log-2.log -o C:\Users\darma\OneDrive\Desktop\result.txt```
    atau
    ```java -jar exporter-jar-with-dependencies.jar -f C:\Users\darma\OneDrive\Desktop\sample-log-2.log -t json -o C:\Users\darma\OneDrive\Desktop\result.json```
    


Hasil Pengujian menggunakan laptop windows
![alt text](https://i.ibb.co/7VqS7cf/result-image.png)
