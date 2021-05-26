package com.afifbaihaqi.movieku.core.data

import com.afifbaihaqi.movieku.core.database.FavoriteMovie
import com.afifbaihaqi.movieku.core.database.FavoriteTv

object DataDummy {

    fun generateDummyMovieTest(): List<FavoriteMovie> {
        val movie = ArrayList<FavoriteMovie>()
        movie.add(
            FavoriteMovie(
                2001,
                "Now You See Me 2",
                "https://107.152.39.187/wp-content/uploads/2018/05/Now-You-See-Me-2-2016-Subtitle-Indonesia-Bluray.jpg",
                "2016",
                "Diceritakan bahwa The Four Horsemen sudah satu tahun bersembunyi, menghindar dari FBI. The Four Horsemen berencana untuk kembali tampil di hadapan publik dengan membajak sebuah acara peluncuran handphone terbaru yang diduga bisa meretas privasi penggunanya.",
                7.9
            )
        )
        movie.add(
            FavoriteMovie(
                2002,
                "Joker",
                "https://107.152.39.187/wp-content/uploads/2019/12/Download-Film-Joker-2019-Sub-Indo.jpg",
                "2019",
                "Film joker berkisah tentang Arthur Fleck (Joaquin Phoenix) seorang pria malang yang hidup dalam kondisi kelam Kota Gotham. Di tengah situasi carut-marut, keseharian Fleck diisi dengan perjuangan keras. ",
                9.0
            )
        )
        movie.add(
            FavoriteMovie(
                2003,
                "Jumanji: The Next Level",
                "https://107.152.39.187/wp-content/uploads/2020/03/Download-Film-Jumanji-The-Next-Level-2019-Sub-Indo.jpg",
                "2019",
                "Kehidupan Spencer Gilpins pasca lulus SMA membuatnya mengalami krisis “insecure”. Tinggal di kota sebesar New York City membuatnya rindu dengan kawan-kawannya yakni Martha Kapley yang menjadi kekasihnya, Anthony “Fridge” Johnson dan Bethany Walker.",
                6.8
            )
        )
        movie.add(
            FavoriteMovie(
                2004,
                "Avengers: Endgame",
                "https://107.152.39.187/wp-content/uploads/2019/07/Download-Film-Avengers-Endgame-2019-Subtitle-Indonesia.jpg",
                "2019",
                "Lanjutan cerita dari Avengers: Infinity war (2018) dimana Thanos telah menjentikan jarinya karena telah memiliki semua infinity stone dan menghabisi setengah penduduk bumi. Semua member Avengers dilanda keputusasaan, amarah, dan dendam terhadap Thanos atas apa yang diperbuatnya.",
                7.1
            )
        )
        movie.add(
            FavoriteMovie(
                2005,
                "Deadpool",
                "https://107.152.39.187/wp-content/uploads/2018/04/Deadpool-2016-Subtitle-Indonesia.jpg",
                "2016",
                "Wade Wilson didiagnosa mengalami kanker dan mendapat tawaran untuk percobaan perubahan genetik yang dapat merubahnya menjadi superhero. Wade pun menerima percobaan pada dirinya tersebut. Percobaan itu pun berhasil dan membuat Wade dijuluki Deadpool.",
                7.8
            )
        )
        movie.add(
            FavoriteMovie(
                2006,
                "Black Panther",
                "https://107.152.39.187/wp-content/uploads/2018/05/Black-Panther-2018-Subtitle-Indonesia.jpg",
                "2018",
                "Anak seorang Raja, T’Challa, berhak mewarisi takhta sang bokap dan menjadi raja baru di tanah Wakanda. Namun, T’Challa langsung dihadapkan dengan berbagai masalah pelik yang menguji kecintaannya terhadap negerinya tersebut, mulai dari vibranium hingga masalah takhta.",
                6.8
            )
        )
        movie.add(
            FavoriteMovie(
                2007,
                "Parasite",
                "https://107.152.39.187/wp-content/uploads/2019/12/Parasite-2019-Subtitle-Indonesia-Bluray.jpg",
                "2019",
                "Keluarga Kim adalah keluarga yang tinggal di semi-basement beranggotakan Ki-taek sang kepala keluarga, Chung-sook istrinya dan kedua anak mereka, Ki-woo dan Ki-jung. Keempatnya tidak memiliki pekerjaan dan bergantung pada pekerjaan sambilan mereka ,melipat box pizza.",
                9.5
            )
        )
        movie.add(
            FavoriteMovie(
                2008,
                "SpongeBob Movie",
                "https://107.152.39.187/wp-content/uploads/2020/11/kYt81ABji13xxTjZDfQtOrC4hg1.jpg",
                "2020",
                "Mengisahkan SpongeBob (Tom Kenny) yang kehilangan Gary. Siput peliharaannya itu tiba-tiba menghilang tanpa jejak dari rumahnya. Meski SpongeBob telah mencarinya ke seluruh penjuru Bikini Bottom, Gary tak berhasil ditemukan. Ia pun menyimpulkan kalau sahabatnya yang bercangkang pink itu diculik.",
                5.7
            )
        )
        movie.add(
            FavoriteMovie(
                2009,
                "Mulan",
                "https://107.152.39.187/wp-content/uploads/2020/09/Download-Film-Mulan-2020-Sub-Indo.jpg",
                "2020",
                "Ketika kaisar Tiongkok mengeluarkan dekrit bahwa satu pria dari setiap keluarga wajib bergabung dalam tentara kekaisaran untuk mempertahankan negara dari serangan bangsa Hun, Hua Mulan, putri tertua dari seorang pejuang terhormat, memutuskan menggantikan ayahnya yang sakit-sakitan.",
                6.5
            )
        )
        movie.add(
            FavoriteMovie(
                2010,
                "The Lion King",
                "https://107.152.39.187/wp-content/uploads/2019/10/Download-Film-The-Lion-King-2019-Subtitle-Indonesia.jpg",
                "2019",
                "Menceritakan tentang Mufasa adalah seekor singa yang juga merupakan seorang leader/pemimpin di Pride Rock. Ia tengah merayakan kelahiran anaknya bersama Sarabi bernama Simba yang diyakini seekor baboon bernama Rafiki sebagai “calon raja”. Adik dari Mufasa yang bernama Scar pun mendengar kabar tersebut.",
                6.9
            )
        )
        return movie
    }

    fun generateDummyTvTest(): List<FavoriteTv> {
        val tv = ArrayList<FavoriteTv>()
        tv.add(
            FavoriteTv(
                3001,
                "The Queen’s Gambit",
                "https://107.152.39.187/wp-content/uploads/2020/11/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
                "2020",
                "Film ini mengisahkan tentang Elizabeth “Beth” Harmon, seorang gadis yatim piatu dengan latar belakang sekitar tahun 1950an. Ia hidup sendiri di panti asuhan setelah ibunya meninggal karena kecelakaan.",
                8.0
            )
        )

        tv.add(
            FavoriteTv(
                3002,
                "Wanda Vision",
                "https://107.152.39.187/wp-content/uploads/2021/01/Download-WandaVision-2021-Sub-Indo.jpg",
                "2021",
                "WandaVision mengisahkan kehidupan rumah tangga Wanda Maximoff alias Scarlet Witch (Elizabeth Olsen) dan Vision (Paul Bettany).Mereka menjalani hidup seperti manusia biasa, bukan pahlawan super. Selain menjalani kehidupan sebagai pasangan suami istri, mereka juga bersosialisasi dengan lingkungan sekitar.",
                7.8
            )
        )
        tv.add(
            FavoriteTv(
                3003,
                "The Witcher",
                "https://107.152.39.187/wp-content/uploads/2019/12/The-Witcher-Season-1-2019-Sub-Indo.jpg",
                "2019",
                "Series ini diadaptasi dari novel fantasi terlaris dunia karya Andrzej Sapkowski. The Witcher menceritakan kisah Geralt dari Rivia, seorang pemburu monster bayaran yang berjuang mencari jati dirinya.",
                6.7
            )
        )
        tv.add(
            FavoriteTv(
                3004,
                "Start-Up",
                "https://107.152.39.187/wp-content/uploads/2020/11/Download-Drama-Korea-Start-Up-2020.jpg",
                "2020",
                "Start-Up berkisah tentang kehidupan karier hingga percintaan para remaja yang bermimpi untuk sukses di dunia perusahaan startup.",
                7.1
            )
        )
        tv.add(
            FavoriteTv(
                3005,
                "Chernobyl",
                "https://107.152.39.187/wp-content/uploads/2019/11/Chernobyl-2019-Sub-Indo.jpg",
                "2019",
                "Chernobyl menampilkan perjuangan para manusia yang terjebak atau berusaha mengatasi bencana kebocoran reaktor nuklir dekat Kota Pripyat, Ukraina, pada 1986 silam. Insiden di Uni Soviet itu nyaris mengancam ratusan juta penduduk Eropa.",
                8.1
            )
        )
        tv.add(
            FavoriteTv(
                3006,
                "Sweet Home",
                "https://107.152.39.187/wp-content/uploads/2020/12/6eMg81CPLalULg8spPt2LxfQtFj.jpg",
                "2020",
                "Cerita ‘Sweet Home’ fokus kepada sosok pemuda introvert bernama Cha Hyun Soo. Suatu hari, Hyun Soo harus rela hidup seorang diri setelah kehilangan seluruh anggota keluarganya yang meninggal dalam sebuah kecelakaan.",
                5.8
            )
        )
        tv.add(
            FavoriteTv(
                3007,
                "Kingdom",
                "https://107.152.39.187/wp-content/uploads/2020/03/Kingdom-Season-1-2019-Sub-Indo.jpg",
                "2019",
                "Putera Mahkota Lee Chang yang diperankan oleh Ju Ji-Hoon mengecam pengkhianat setelah Raja yang mati hidup kembali. Dia berusaha untuk mengungkap kebenaran di balik orang-orang yang berubah menjadi zombie setelah kelaparan.",
                5.1
            )
        )
        tv.add(
            FavoriteTv(
                3008,
                "Alice in Borderland",
                "https://107.152.39.187/wp-content/uploads/2020/12/20mOwAAPwZ1vLQkw0fvuQHiG7bO.jpg",
                "2020",
                "Alice in Borderland mengisahkan sebuah masyarakat yang suram, pembunuhan dan kelangsungan hidup menjadi konsentrasi dari plot cerita.",
                8.3
            )
        )
        tv.add(
            FavoriteTv(
                3009,
                "The Mandalorian",
                "https://107.152.39.187/wp-content/uploads/2020/03/The-Mandalorian-2019-Sub-Indo.jpg",
                "2019",
                "Setelah kisah Jango dan Bobba Fett, ksatria lainnya muncul dalam semesta Star Wars. The Mandalorian berlatar setelah kejatuhan Kekaisaran, sebelum kemunculan First Order.",
                8.4
            )
        )
        tv.add(
            FavoriteTv(
                3010,
                "Crash Landing on You",
                "https://107.152.39.187/wp-content/uploads/2020/04/Crash-Landing-on-You-2019-Sub-Indo.jpg",
                "2019",
                "Crash Landing on You berkisahkan tentang Kisah cinta mutlak yang sangat rahasia dari seorang ahli waris chaebol yang melakukan pendaratan darurat di Korea Utara karena kecelakaan paralayang dan seorang petugas khusus Korea Utara yang jatuh cinta padanya dan yang menyembunyikan dan melindunginya.",
                6.3
            )
        )
        return tv
    }
    fun generateDummyMovieDetail(): FavoriteMovie = generateDummyMovieTest()[0]
    fun generateDummyTvDetail(): FavoriteTv = generateDummyTvTest()[0]

    fun setFavoriteMovie(course: FavoriteMovie, bookmarked: Boolean): FavoriteMovie {
        course.favorite = bookmarked
        return course
    }

}