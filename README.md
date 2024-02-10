# Cafe2K
Cafe2K adalah aplikasi untuk memanjemen cafe sederhana; 

## Tech
##### Perangkat Lunak
- JDK 8
- NetBeans IDE 15
- PostgreSQL 14

##### Liblary
- PostgreSQL JDBC Driver `NetBeans`
- Absolute Layout `NetBeans`
- EnclipseLink (JPA 2.1) `NetBeans`
- [JasperReport](https://drive.google.com/drive/folders/1j5_8GSWe5ZPekZ98PfehL3avy_HWa5Jr?usp=drive_link)
- [JavaxMail](https://drive.google.com/drive/folders/1ZxoJk1mjWt1YF1eKs9BGL3a7xHVf7vnR?usp=drive_link)
- [JCalendar](https://drive.google.com/drive/folders/16my4TG-ob4uI_akGUEDkvdCrCuhLc78n?usp=drive_link)


## Installation

Buat database `Cafe2K` pada PosgreSQL
```sh
/*==============================================================*/
/* Table: BAHAN                                                 */
/*==============================================================*/
create table BAHAN (
   KODE_BAHAN           CHAR(5)              not null,
   NAMA                 VARCHAR(30)          null,
   HARGA                INT8                 null,
   STOK                 INT4                 null,
   constraint PK_BAHAN primary key (KODE_BAHAN)
);

/*==============================================================*/
/* Index: BAHAN_PK                                              */
/*==============================================================*/
create unique index BAHAN_PK on BAHAN (
KODE_BAHAN
);

/*==============================================================*/
/* Table: DETAIL_BAHAN                                          */
/*==============================================================*/
create table DETAIL_BAHAN (
   KODE_MENU            CHAR(5)              not null,
   KODE_BAHAN           CHAR(5)              not null,
   JUMLAH               INT4                 null,
   constraint PK_DETAIL_BAHAN primary key (KODE_MENU, KODE_BAHAN)
);

/*==============================================================*/
/* Index: DETAIL_BAHAN_PK                                       */
/*==============================================================*/
create unique index DETAIL_BAHAN_PK on DETAIL_BAHAN (
KODE_MENU,
KODE_BAHAN
);

/*==============================================================*/
/* Index: MEMILIKI2_FK                                          */
/*==============================================================*/
create  index MEMILIKI2_FK on DETAIL_BAHAN (
KODE_BAHAN
);

/*==============================================================*/
/* Index: MEMILIKI1_FK                                          */
/*==============================================================*/
create  index MEMILIKI1_FK on DETAIL_BAHAN (
KODE_MENU
);

/*==============================================================*/
/* Table: DETAIL_MASAK                                          */
/*==============================================================*/
create table DETAIL_MASAK (
   ID_PEGAWAI           CHAR(5)              not null,
   NO_MASAK             CHAR(10)             not null,
   KODE_MENU            CHAR(5)              not null,
   JUMLAH               INT4                 null,
   constraint PK_DETAIL_MASAK primary key (ID_PEGAWAI, NO_MASAK, KODE_MENU)
);

/*==============================================================*/
/* Index: DETAIL_MASAK_PK                                       */
/*==============================================================*/
create unique index DETAIL_MASAK_PK on DETAIL_MASAK (
ID_PEGAWAI,
NO_MASAK,
KODE_MENU
);

/*==============================================================*/
/* Index: MEMILIKI32_FK                                         */
/*==============================================================*/
create  index MEMILIKI32_FK on DETAIL_MASAK (
KODE_MENU
);

/*==============================================================*/
/* Index: MEMILIKI31_FK                                         */
/*==============================================================*/
create  index MEMILIKI31_FK on DETAIL_MASAK (
ID_PEGAWAI,
NO_MASAK
);

/*==============================================================*/
/* Table: DETAIL_PEMBELIAN                                      */
/*==============================================================*/
create table DETAIL_PEMBELIAN (
   KODE_MENU            CHAR(5)              not null,
   ID_PEGAWAI           CHAR(5)              not null,
   ID_PELANGGAN         CHAR(10)             not null,
   NO_PEMBELIAN         CHAR(10)             not null,
   JUMLAH               INT4                 null,
   SUBTOTAL             INT8                 null,
   KETERANGAN           VARCHAR(100)         null,
   constraint PK_DETAIL_PEMBELIAN primary key (KODE_MENU, ID_PEGAWAI, ID_PELANGGAN, NO_PEMBELIAN)
);

/*==============================================================*/
/* Index: DETAIL_PEMBELIAN_PK                                   */
/*==============================================================*/
create unique index DETAIL_PEMBELIAN_PK on DETAIL_PEMBELIAN (
KODE_MENU,
ID_PEGAWAI,
ID_PELANGGAN,
NO_PEMBELIAN
);

/*==============================================================*/
/* Index: MEMILIKI5_FK                                          */
/*==============================================================*/
create  index MEMILIKI5_FK on DETAIL_PEMBELIAN (
ID_PEGAWAI,
ID_PELANGGAN,
NO_PEMBELIAN
);

/*==============================================================*/
/* Index: MEMILIKI6_FK                                          */
/*==============================================================*/
create  index MEMILIKI6_FK on DETAIL_PEMBELIAN (
KODE_MENU
);

/*==============================================================*/
/* Table: DETAIL_SUPPLY                                         */
/*==============================================================*/
create table DETAIL_SUPPLY (
   KODE_BAHAN           CHAR(5)              not null,
   ID_SUPPLIER          CHAR(10)             not null,
   ID_PEGAWAI           CHAR(5)              not null,
   NO_SUPPLY            CHAR(10)             not null,
   JUMLAH               INT4                 null,
   SUBTOTAL             INT8                 null,
   KETERANGAN           VARCHAR(100)         null,
   constraint PK_DETAIL_SUPPLY primary key (KODE_BAHAN, ID_SUPPLIER, ID_PEGAWAI, NO_SUPPLY)
);

/*==============================================================*/
/* Index: DETAIL_SUPPLY_PK                                      */
/*==============================================================*/
create unique index DETAIL_SUPPLY_PK on DETAIL_SUPPLY (
KODE_BAHAN,
ID_SUPPLIER,
ID_PEGAWAI,
NO_SUPPLY
);

/*==============================================================*/
/* Index: MEMILIKI7_FK                                          */
/*==============================================================*/
create  index MEMILIKI7_FK on DETAIL_SUPPLY (
ID_SUPPLIER,
ID_PEGAWAI,
NO_SUPPLY
);

/*==============================================================*/
/* Index: MEMILIKI8_FK                                          */
/*==============================================================*/
create  index MEMILIKI8_FK on DETAIL_SUPPLY (
KODE_BAHAN
);

/*==============================================================*/
/* Table: MEMASAK                                               */
/*==============================================================*/
create table MEMASAK (
   ID_PEGAWAI           CHAR(5)              not null,
   TANGGAL              DATE                 null,
   KETERANGAN           VARCHAR(100)         null,
   NO_MASAK             CHAR(10)             not null,
   constraint PK_MEMASAK primary key (ID_PEGAWAI, NO_MASAK)
);

/*==============================================================*/
/* Index: MEMASAK_PK                                            */
/*==============================================================*/
create unique index MEMASAK_PK on MEMASAK (
ID_PEGAWAI,
NO_MASAK
);

/*==============================================================*/
/* Index: MELAKUKAN_FK                                          */
/*==============================================================*/
create  index MELAKUKAN_FK on MEMASAK (
ID_PEGAWAI
);

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU (
   KODE_MENU            CHAR(5)              not null,
   NAMA                 VARCHAR(30)          null,
   HARGA                INT8                 null,
   STOK                 INT4                 null,
   constraint PK_MENU primary key (KODE_MENU)
);

/*==============================================================*/
/* Index: MENU_PK                                               */
/*==============================================================*/
create unique index MENU_PK on MENU (
KODE_MENU
);

/*==============================================================*/
/* Table: PEGAWAI                                               */
/*==============================================================*/
create table PEGAWAI (
   ID_PEGAWAI           CHAR(5)              not null,
   NAMA                 VARCHAR(30)          null,
   ALAMAT               VARCHAR(100)         null,
   TELEPHONE            VARCHAR(13)          null,
   EMAIL                VARCHAR(30)          null,
   LEVEL                VARCHAR(10)          null,
   USERNAME             VARCHAR(30)          null,
   PASSWORD             VARCHAR(100)         null,
   FOTO                 BYTEA                null,
   constraint PK_PEGAWAI primary key (ID_PEGAWAI)
);

/*==============================================================*/
/* Index: PEGAWAI_PK                                            */
/*==============================================================*/
create unique index PEGAWAI_PK on PEGAWAI (
ID_PEGAWAI
);

/*==============================================================*/
/* Table: PELANGGAN                                             */
/*==============================================================*/
create table PELANGGAN (
   ID_PELANGGAN         CHAR(10)             not null,
   NAMA                 VARCHAR(30)          null,
   ALAMAT               VARCHAR(100)         null,
   TELEPHONE            VARCHAR(13)          null,
   constraint PK_PELANGGAN primary key (ID_PELANGGAN)
);

/*==============================================================*/
/* Index: PELANGGAN_PK                                          */
/*==============================================================*/
create unique index PELANGGAN_PK on PELANGGAN (
ID_PELANGGAN
);

/*==============================================================*/
/* Table: PEMBELIAN                                             */
/*==============================================================*/
create table PEMBELIAN (
   ID_PEGAWAI           CHAR(5)              not null,
   ID_PELANGGAN         CHAR(10)             not null,
   NO_PEMBELIAN         CHAR(10)             not null,
   TANGGAL              DATE                 null,
   TOTAL                INT8                 null,
   STATUS               VARCHAR(11)          null,
   constraint PK_PEMBELIAN primary key (ID_PEGAWAI, ID_PELANGGAN, NO_PEMBELIAN)
);

/*==============================================================*/
/* Index: PEMBELIAN_PK                                          */
/*==============================================================*/
create unique index PEMBELIAN_PK on PEMBELIAN (
ID_PEGAWAI,
ID_PELANGGAN,
NO_PEMBELIAN
);

/*==============================================================*/
/* Index: MELAKUKAN1_FK                                         */
/*==============================================================*/
create  index MELAKUKAN1_FK on PEMBELIAN (
ID_PELANGGAN
);

/*==============================================================*/
/* Index: MEMILIKI3_FK                                          */
/*==============================================================*/
create  index MEMILIKI3_FK on PEMBELIAN (
ID_PEGAWAI
);

/*==============================================================*/
/* Table: SUPPLIER                                              */
/*==============================================================*/
create table SUPPLIER (
   ID_SUPPLIER          CHAR(10)             not null,
   NAMA                 VARCHAR(30)          null,
   ALAMAT               VARCHAR(100)         null,
   TELEPHONE            VARCHAR(13)          null,
   constraint PK_SUPPLIER primary key (ID_SUPPLIER)
);

/*==============================================================*/
/* Index: SUPPLIER_PK                                           */
/*==============================================================*/
create unique index SUPPLIER_PK on SUPPLIER (
ID_SUPPLIER
);

/*==============================================================*/
/* Table: SUPPLY                                                */
/*==============================================================*/
create table SUPPLY (
   ID_SUPPLIER          CHAR(10)             not null,
   ID_PEGAWAI           CHAR(5)              not null,
   NO_SUPPLY            CHAR(10)             not null,
   TANGGAL              DATE                 null,
   TOTAL                INT8                 null,
   constraint PK_SUPPLY primary key (ID_SUPPLIER, ID_PEGAWAI, NO_SUPPLY)
);

/*==============================================================*/
/* Index: SUPPLY_PK                                             */
/*==============================================================*/
create unique index SUPPLY_PK on SUPPLY (
ID_SUPPLIER,
ID_PEGAWAI,
NO_SUPPLY
);

/*==============================================================*/
/* Index: MELAKUKAN2_FK                                         */
/*==============================================================*/
create  index MELAKUKAN2_FK on SUPPLY (
ID_PEGAWAI
);

/*==============================================================*/
/* Index: MEMASOK_FK                                            */
/*==============================================================*/
create  index MEMASOK_FK on SUPPLY (
ID_SUPPLIER
);

alter table DETAIL_BAHAN
   add constraint FK_DETAIL_B_MEMILIKI1_MENU foreign key (KODE_MENU)
      references MENU (KODE_MENU)
      on delete restrict on update restrict;

alter table DETAIL_BAHAN
   add constraint FK_DETAIL_B_MEMILIKI2_BAHAN foreign key (KODE_BAHAN)
      references BAHAN (KODE_BAHAN)
      on delete restrict on update restrict;

alter table DETAIL_MASAK
   add constraint FK_DETAIL_M_MEMILIKI3_MEMASAK foreign key (ID_PEGAWAI, NO_MASAK)
      references MEMASAK (ID_PEGAWAI, NO_MASAK)
      on delete restrict on update restrict;

alter table DETAIL_MASAK
   add constraint FK_DETAIL_M_MEMILIKI3_MENU foreign key (KODE_MENU)
      references MENU (KODE_MENU)
      on delete restrict on update restrict;

alter table DETAIL_PEMBELIAN
   add constraint FK_DETAIL_P_MEMILIKI5_PEMBELIA foreign key (ID_PEGAWAI, ID_PELANGGAN, NO_PEMBELIAN)
      references PEMBELIAN (ID_PEGAWAI, ID_PELANGGAN, NO_PEMBELIAN)
      on delete restrict on update restrict;

alter table DETAIL_PEMBELIAN
   add constraint FK_DETAIL_P_MEMILIKI6_MENU foreign key (KODE_MENU)
      references MENU (KODE_MENU)
      on delete restrict on update restrict;

alter table DETAIL_SUPPLY
   add constraint FK_DETAIL_S_MEMILIKI7_SUPPLY foreign key (ID_SUPPLIER, ID_PEGAWAI, NO_SUPPLY)
      references SUPPLY (ID_SUPPLIER, ID_PEGAWAI, NO_SUPPLY)
      on delete restrict on update restrict;

alter table DETAIL_SUPPLY
   add constraint FK_DETAIL_S_MEMILIKI8_BAHAN foreign key (KODE_BAHAN)
      references BAHAN (KODE_BAHAN)
      on delete restrict on update restrict;

alter table MEMASAK
   add constraint FK_MEMASAK_MELAKUKAN_PEGAWAI foreign key (ID_PEGAWAI)
      references PEGAWAI (ID_PEGAWAI)
      on delete restrict on update restrict;

alter table PEMBELIAN
   add constraint FK_PEMBELIA_MELAKUKAN_PELANGGA foreign key (ID_PELANGGAN)
      references PELANGGAN (ID_PELANGGAN)
      on delete restrict on update restrict;

alter table PEMBELIAN
   add constraint FK_PEMBELIA_MEMILIKI3_PEGAWAI foreign key (ID_PEGAWAI)
      references PEGAWAI (ID_PEGAWAI)
      on delete restrict on update restrict;

alter table SUPPLY
   add constraint FK_SUPPLY_MELAKUKAN_PEGAWAI foreign key (ID_PEGAWAI)
      references PEGAWAI (ID_PEGAWAI)
      on delete restrict on update restrict;

alter table SUPPLY
   add constraint FK_SUPPLY_MEMASOK_SUPPLIER foreign key (ID_SUPPLIER)
      references SUPPLIER (ID_SUPPLIER)
      on delete restrict on update restrict;

INSERT INTO pegawai (
	id_pegawai, 
	nama, 
	alamat, 
	telephone, 
	email, 
	level, 
	username, 
	password
) VALUES (
	'PT001',
	'Admin',
	'-',
	'0',
	'fatiq5127@gmail.com',
	'Admin',
	'admin',
	'21232f297a57a5a743894a0e4a801fc3'
);

INSERT INTO supplier (
	id_supplier, 
	nama, 
	alamat, 
	telephone
) VALUES (
	'S000000001',
	'Tidak diketahui',
	'-',
	'0'
);

INSERT INTO pelanggan (
	id_pelanggan, 
	nama, 
	alamat, 
	telephone
) VALUES (
	'P000000001',
	'Tidak diketahui',
	'-',
	'0'
);
```

Berikut adalah `DML`, query ini tidak wajib dimasukkan.
```sh
INSERT INTO pelanggan VALUES
('P231214002','Ahmad Farhan','Tuban','082376432654'),
('P231214003','Siti Rahayu','Gresik','082376432655'),
('P231214004','Rizki Pratama','Lamongan','082376432656'),
('P231214005','Devi Anggraeni','Bojonegoro','082376432657'),
('P231214006','Dian Nugraha','Surabaya','082376432658'),
('P231214007','Faisal Ramadhan','Sidoarjo','082376432659'),
('P231214008','Nia Fitriani','Jenu','082376432660'),
('P231214009','Aditya Putra','Manyar','082376432661'),
('P231214010','Maya Sari','Ngimbang','082376432662'),
('P231214011','Irfan Setiawan','Baureno','082376432663'),
('P231214012','Rina Indriani','Pucuk','082376432664'),
('P231214013','Agus Santoso','Kerek','082376432665'),
('P231214014','Yulia Prameswari','Widang','082376432666'),
('P231214015','Dodi Saputra','Sekar','082376432667'),
('P231214016','Lina Purnama','Tambakboyo','082376432668'),
('P231214017','Bambang Wijaya','Kedamean','082376432669'),
('P231214018','Novi Kurniawan','Cerme','082376432670'),
('P231214019','Eka Surya','Benjeng','082376432671'),
('P231214020','Rini Agustina','Balongpanggang','082376432672'),
('P231214021','Toni Prasetyo','Jabon','082376432673'),
('P231214022','Fitria Ramadhani','Wringinanom','082376432674'),
('P231214023','Dedy Prabowo','Driyorejo','082376432675'),
('P231214024','Santi Wulandari','Sedati','082376432676'),
('P231214025','Joko Susanto','Waru','082376432677'),
('P231214026','Tika Putri','Tanggulangin','082376432678'),
('P231214027','Arianto','Taman','082376432679'),
('P231214028','Lutfi Anwar','Sukodono','082376432680'),
('P231214029','Mega Utami','Gedangan','082376432681'),
('P231214030','Ryan Nugroho','Tarik','082376432682'),
('P231214031','Siti Hidayah','Prambon','082376432683'),
('P231214032','Firda Ayu','Rembang','082376432684'),
('P231214033','Yusuf Hadi','Krembung','082376432685'),
('P231214034','Nisa Rahman','Porong','082376432686'),
('P231214035','Budi Setiawan','Krian','082376432687'),
('P231214036','Dewi Sartika','Buduran','082376432688'),
('P231214037','Agung Prabowo','Turi','082376432689'),
('P231214038','Rini Agustina','Grati','082376432690'),
('P231214039','Arya Saputra','Nguling','082376432691'),
('P231214040','Yuni Susanti','Tarik','082376432692'),
('P231214041','Dwi Putri','Pungging','082376432693'),
('P231214042','Yanto Wijaya','Wonoayu','082376432694'),
('P231214043','Nia Fadilah','Balong','082376432695'),
('P231214044','Dian Setiawan','Jatirejo','082376432696'),
('P231214045','Bayu Pratama','Mojo','082376432697'),
('P231214046','Lina Febrianti','Ngoro','082376432698'),
('P231214047','Eko Susilo','Ngronggot','082376432699'),
('P231214048','Nita Kusuma','Jatipurno','082376432700'),
('P231214049','Rizal Hermawan','Dander','082376432701'),
('P231214050','Indah Permata','Pacet','082376432702'),
('P231214051','Hadi Santoso','Nganjuk','082376432703'),
('P231214052','Sari Lestari','Ngawi','082376432704'),
('P231214053','Bima Prasetya','Ponorogo','082376432705'),
('P231214054','Wulan Kusuma','Madiun','082376432706'),
('P231214055','Dwi Nugroho','Magetan','082376432707'),
('P231214056','Desi Anggraini','Pacitan','082376432708'),
('P231214057','Fajar Prabowo','Trenggalek','082376432709'),
('P231214058','Ika Sari','Tulungagung','082376432710'),
('P231214059','Ahmad Hidayat','Blitar','082376432711'),
('P231214060','Rina Wulandari','Kediri','082376432712'),
('P231214061','Roni Saputra','Malang','082376432713'),
('P231214062','Yuni Fitri','Batu','082376432714'),
('P231214063','Dika Kurniawan','Pasuruan','082376432715'),
('P231214064','Lulu Hasanah','Probolinggo','082376432716'),
('P231214065','Agung Setiawan','Lumajang','082376432717'),
('P231214066','Lia Rahmawati','Jember','082376432718'),
('P231214067','Farid Rahman','Banyuwangi','082376432719'),
('P231214068','Putri Astuti','Bondowoso','082376432720'),
('P231214069','Rizki Fitri','Situbondo','082376432721'),
('P231214070','Arif Pratama','Sumenep','082376432722'),
('P231214071','Yuli Susilawati','Pamekasan','082376432723'),
('P231214072','Denny Saputra','Sampang','082376432724'),
('P231214073','Lia Putri','Bangkalan','082376432725'),
('P231214074','Taufik Hidayat','Madura','082376432726'),
('P231214075','Vina Utami','Bawean','082376432727'),
('P231214076','Andi Setiawan','Gunung Kidul','082376432728'),
('P231214077','Retno Wahyuni','Sleman','082376432729'),
('P231214078','Dika Permana','Kulon Progo','082376432730'),
('P231214079','Maya Hartati','Bantul','082376432731'),
('P231214080','Yuda Pratama','Wates','082376432732'),
('P231214081','Ani Suryani','Wonosari','082376432733'),
('P231214082','Arief Wijaya','Wonogiri','082376432734'),
('P231214083','Yunita Sari','Karanganyar','082376432735'),
('P231214084','Indra Kusuma','Sragen','082376432736'),
('P231214085','Retno Wulandari','Sukoharjo','082376432737'),
('P231214086','Dedi Suryanto','Klaten','082376432738'),
('P231214087','Susi Rahayu','Boyolali','082376432739'),
('P231214088','Yoga Prasetyo','Solo','082376432740'),
('P231214089','Rina Permatasari','Salatiga','082376432741'),
('P231214090','Dedi Setiawan','Semarang','082376432742'),
('P231214091','Dewi Yuliana','Demak','082376432743'),
('P231214092','Asep Rahman','Grobogan','082376432744'),
('P231214093','Citra Dewi','Blora','082376432745'),
('P231214094','Dian Novita','Rembang','082376432746'),
('P231214095','Wawan Kusnadi','Pati','082376432747'),
('P231214096','Rina Kurniawan','Kudus','082376432748'),
('P231214097','Agus Setiawan','Jepara','082376432749'),
('P231214098','Evi Setiawan','Kendal','082376432750'),
('P231214099','Ade Surya','Batang','082376432751'),
('P231214100','Sari Wulandari','Pekalongan','082376432752'),
('P231214101','Indra Susanto','Tegal','082376432753'),
('P231214102','Lia Kusuma','Brebes','082376432754'),
('P231214103','Rizki Hermawan','Pemalang','082376432755'),
('P231214104','Nita Hidayah','Purbalingga','082376432756'),
('P231214105','Dian Sari','Banjarnegara','082376432757'),
('P231214106','Yoga Setiawan','Wonosobo','082376432758'),
('P231214107','Rini Susanti','Magelang','082376432759'),
('P231214108','Fandi Pratama','Temanggung','082376432760'),
('P231214109','Ika Setiawati','Semarang','082376432761'),
('P231214110','Denny Setiawan','Kendal','082376432762'),
('P231214111','Dewi Setiani','Batang','082376432763'),
('P231214112','Dedi Kurniawan','Pekalongan','082376432764'),
('P231214113','Fitri Indah','Tegal','082376432765'),
('P231214114','Irfan Surya','Brebes','082376432766'),
('P231214115','Mega Prasetyo','Pemalang','082376432767'),
('P231214116','Rina Novianti','Purbalingga','082376432768'),
('P231214117','Dani Setiawan','Banjarnegara','082376432769'),
('P231214118','Hani Fitriani','Wonosobo','082376432770'),
('P231214119','Agus Setiadi','Magelang','082376432771'),
('P231214120','Dian Kusumawati','Temanggung','082376432772'),
('P231214121','Rendi Pratama','Purworejo','082376432773'),
('P231214122','Eka Yulianto','Kebumen','082376432774'),
('P231214123','Novi Susanti','Banjar','082376432775'),
('P231214124','Yoga Wijaya','Cilacap','082376432776'),
('P231214125','Ira Rahayu','Banyumas','082376432777'),
('P231214126','Fandi Setiawan','Purbalingga','082376432778'),
('P231214127','Yuli Rahmawati','Banjarnegara','082376432779'),
('P231214128','Dicky Prasetyo','Kebumen','082376432780'),
('P231214129','Rina Fitri','Purworejo','082376432781'),
('P231214130','Surya Wijaya','Kutoarjo','082376432782'),
('P231214131','Dian Fitriani','Purwokerto','082376432783'),
('P231214132','Bayu Setiawan','Pemalang','082376432784'),
('P231214133','Irma Sari','Tegal','082376432785'),
('P231214134','Dedi Kusnadi','Pekalongan','082376432786'),
('P231214135','Lina Wulandari','Pemalang','082376432787'),
('P231214136','Dwi Setiawan','Pekalongan','082376432788'),
('P231214137','Mega Kurniawan','Tegal','082376432789'),
('P231214138','Arianto Pratama','Brebes','082376432790'),
('P231214139','Susi Fitri','Pemalang','082376432791'),
('P231214140','Rizal Wijaya','Tegal','082376432792'),
('P231214141','Dita Kurniawan','Kudus','082376432793'),
('P231214142','Dwi Agustini','Pati','082376432794'),
('P231214143','Dicky Setiawan','Rembang','082376432795'),
('P231214144','Rini Kusuma','Blora','082376432796'),
('P231214145','Arifin Setiawan','Jepara','082376432797'),
('P231214146','Nia Rahmawati','Demak','082376432798'),
('P231214147','Rizki Prasetyo','Semarang','082376432799'),
('P231214148','Nita Setiawati','Magelang','082376432800'),
('P231214149','Yuda Setiawan','Salatiga','082376432801'),
('P231214150','Dewi Kurniawati','Solo','082376432802'),
('P231214151','Dian Fitria','Yogyakarta','082376432803');

INSERT INTO supplier VALUES
('S231214002','Bumi Rasa Sejahtera','Tuban','082376432654'),
('S231214003','Sentosa Food Distributor','Gresik','082376432655'),
('S231214004','Berkah Buah Segar','Lamongan','082376432656'),
('S231214005','Lautan Ikan Prima','Bojonegoro','082376432657'),
('S231214006','Tani Makmur Sayuran','Surabaya','082376432658'),
('S231214007','Daging Sumber Bersih','Sidoarjo','082376432659'),
('S231214008','Organik Sejahtera','Jenu','082376432660'),
('S231214009','Bumbu Sedap Jaya','Manyar','082376432661'),
('S231214010','Minuman Segar Pratama','Ngimbang','082376432662'),
('S231214011','Susu Berkah','Baureno','082376432663'),
('S231214012','Pabrik Bahan Kering Maju Jaya','Pucuk','082376432664'),
('S231214013','Sumber Sehat Produk Olahan','Kerek','082376432665'),
('S231214014','Nelayan Berseri','Widang','082376432666'),
('S231214015','CV ABC Pangan','Sekar','082376432667'),
('S231214016','Buah Segar Berkah','Tambakboyo','082376432668'),
('S231214017','Mitra Daging Utama','Kedamean','082376432669'),
('S231214018','Bumi Organik Indo','Cerme','082376432670'),
('S231214019','Pabrik Makanan Inovatif','Benjeng','082376432671'),
('S231214020','Pemasok Buah Sayur Segar','Balongpanggang','082376432672'),
('S231214021','Rasa Enak Pangan','Jabon','082376432673'),
('S231214022','IndoFood Distributor','Wringinanom','082376432674'),
('S231214023','Bumbu Nusantara Sejahtera','Driyorejo','082376432675'),
('S231214024','Air Minum Berkualitas','Sedati','082376432676'),
('S231214025','Sumber Susu Murni','Waru','082376432677'),
('S231214026','Sentosa Boga Prima','Tanggulangin','082376432678'),
('S231214027','Lautan Ikan Hijau','Taman','082376432679'),
('S231214028','Pabrik Bahan Penyedap Sehat','Sukodono','082376432680'),
('S231214029','Berkah Organik','Gedangan','082376432681'),
('S231214030','Bumbu Segar Jaya','Tarik','082376432682'),
('S231214031','Pemasok Daging Terpercaya','Prambon','082376432683'),
('S231214032','IndoBuah Distributor','Rembang','082376432684'),
('S231214033','Rasa Makmur','Krembung','082376432685'),
('S231214034','Mitra Sayur Berkah','Porong','082376432686'),
('S231214035','Sentosa Boga Sehat','Krian','082376432687'),
('S231214036','Pabrik Minuman Segar Jaya','Buduran','082376432688'),
('S231214037','Susu Sehat Abadi','Turi','082376432689'),
('S231214038','Rasa Enak Pangan','Grati','082376432690'),
('S231214039','Berkah Organik Indo','Nguling','082376432691'),
('S231214040','Pabrik Produk Makanan Inovatif','Tarik','082376432692'),
('S231214041','Bahan Kering Segar','Pungging','082376432693'),
('S231214042','IndoDaging Distributor','Wonoayu','082376432694'),
('S231214043','Buah Segar Berkah','Balong','082376432695'),
('S231214044','Daging Sehat Utama','Jatirejo','082376432696'),
('S231214045','Organik Nusantara','Mojo','082376432697'),
('S231214046','Bumbu Rasa Sejahtera','Ngoro','082376432698'),
('S231214047','Air Minum Sehat','Ngronggot','082376432699'),
('S231214048','Sumber Susu Berkah','Jatipurno','082376432700'),
('S231214049','Sentosa Boga Prima','Dander','082376432701'),
('S231214050','Lautan Ikan Segar','Pacet','082376432702'),
('S231214051','Pabrik Bahan Penyedap Inovatif','Nganjuk','082376432703'),
('S231214052','Berkah Organik','Ngawi','082376432704'),
('S231214053','Bumbu Segar Jaya','Ponorogo','082376432705'),
('S231214054','Pemasok Daging Terpercaya','Madiun','082376432706'),
('S231214055','IndoBuah Distributor','Magetan','082376432707'),
('S231214056','Rasa Makmur','Pacitan','082376432708'),
('S231214057','Mitra Sayur Berkah','Trenggalek','082376432709'),
('S231214058','Sentosa Boga Sehat','Tulungagung','082376432710'),
('S231214059','Pabrik Minuman Segar Jaya','Blitar','082376432711'),
('S231214060','Susu Sehat Abadi','Kediri','082376432712'),
('S231214061','Rasa Enak Pangan','Malang','082376432713'),
('S231214062','Berkah Organik Indo','Batu','082376432714'),
('S231214063','Pabrik Produk Makanan Inovatif','Pasuruan','082376432715'),
('S231214064','Bahan Kering Segar','Probolinggo','082376432716'),
('S231214065','IndoDaging Distributor','Lumajang','082376432717'),
('S231214066','Buah Segar Berkah','Jember','082376432718'),
('S231214067','Daging Sehat Utama','Banyuwangi','082376432719'),
('S231214068','Organik Nusantara','Bondowoso','082376432720'),
('S231214069','Bumbu Rasa Sejahtera','Situbondo','082376432721'),
('S231214070','Air Minum Sehat','Sumenep','082376432722'),
('S231214071','Sumber Susu Berkah','Pamekasan','082376432723'),
('S231214072','Sentosa Boga Prima','Sampang','082376432724'),
('S231214073','Lautan Ikan Segar','Bangkalan','082376432725'),
('S231214074','Pabrik Bahan Penyedap Inovatif','Madura','082376432726'),
('S231214075','Berkah Organik','Bawean','082376432727'),
('S231214076','Bumbu Segar Jaya','Gunung Kidul','082376432728'),
('S231214077','Pemasok Daging Terpercaya','Sleman','082376432729'),
('S231214078','IndoBuah Distributor','Kulon Progo','082376432730'),
('S231214079','Rasa Makmur','Bantul','082376432731'),
('S231214080','Mitra Sayur Berkah','Wates','082376432732'),
('S231214081','Sentosa Boga Sehat','Wonosari','082376432733'),
('S231214082','Pabrik Minuman Segar Jaya','Wonogiri','082376432734'),
('S231214083','Susu Sehat Abadi','Karanganyar','082376432735'),
('S231214084','Rasa Enak Pangan','Sragen','082376432736'),
('S231214085','Berkah Organik Indo','Sukoharjo','082376432737'),
('S231214086','Pabrik Produk Makanan Inovatif','Klaten','082376432738'),
('S231214087','Bahan Kering Segar','Boyolali','082376432739'),
('S231214088','IndoDaging Distributor','Solo','082376432740'),
('S231214089','Buah Segar Berkah','Salatiga','082376432741'),
('S231214090','Daging Sehat Utama','Semarang','082376432742'),
('S231214091','Organik Nusantara','Demak','082376432743'),
('S231214092','Bumbu Rasa Sejahtera','Grobogan','082376432744'),
('S231214093','Air Minum Sehat','Blora','082376432745'),
('S231214094','Sumber Susu Berkah','Rembang','082376432746'),
('S231214095','Sentosa Boga Prima','Pati','082376432747'),
('S231214096','Lautan Ikan Segar','Kudus','082376432748'),
('S231214097','Pabrik Bahan Penyedap Inovatif','Jepara','082376432749'),
('S231214098','Berkah Organik','Kendal','082376432750'),
('S231214099','Bumbu Segar Jaya','Batang','082376432751'),
('S231214100','Pemasok Daging Terpercaya','Pekalongan','082376432752'),
('S231214101','IndoBuah Distributor','Tegal','082376432753'),
('S231214102','Rasa Makmur','Brebes','082376432754'),
('S231214103','Mitra Sayur Berkah','Pemalang','082376432755'),
('S231214104','Sentosa Boga Sehat','Purbalingga','082376432756'),
('S231214105','Pabrik Minuman Segar Jaya','Banjarnegara','082376432757'),
('S231214106','Susu Sehat Abadi','Wonosobo','082376432758'),
('S231214107','Rasa Enak Pangan','Magelang','082376432759'),
('S231214108','Berkah Organik Indo','Temanggung','082376432760'),
('S231214109','Pabrik Produk Makanan Inovatif','Semarang','082376432761'),
('S231214110','Bahan Kering Segar','Kendal','082376432762'),
('S231214111','IndoDaging Distributor','Batang','082376432763'),
('S231214112','Buah Segar Berkah','Pekalongan','082376432764'),
('S231214113','Daging Sehat Utama','Tegal','082376432765'),
('S231214114','Organik Nusantara','Brebes','082376432766'),
('S231214115','Bumbu Rasa Sejahtera','Pemalang','082376432767'),
('S231214116','Air Minum Sehat','Purbalingga','082376432768'),
('S231214117','Sumber Susu Berkah','Banjarnegara','082376432769'),
('S231214118','Sentosa Boga Prima','Wonosobo','082376432770'),
('S231214119','Lautan Ikan Segar','Magelang','082376432771'),
('S231214120','Pabrik Bahan Penyedap Inovatif','Temanggung','082376432772'),
('S231214121','Berkah Organik','Purworejo','082376432773'),
('S231214122','Bumbu Segar Jaya','Kebumen','082376432774'),
('S231214123','Pemasok Daging Terpercaya','Banjar','082376432775'),
('S231214124','IndoBuah Distributor','Cilacap','082376432776'),
('S231214125','Rasa Makmur','Banyumas','082376432777'),
('S231214126','Mitra Sayur Berkah','Purbalingga','082376432778'),
('S231214127','Sentosa Boga Sehat','Banjarnegara','082376432779'),
('S231214128','Pabrik Minuman Segar Jaya','Kebumen','082376432780'),
('S231214129','Susu Sehat Abadi','Purworejo','082376432781'),
('S231214130','Rasa Enak Pangan','Kutoarjo','082376432782'),
('S231214131','Berkah Organik Indo','Purwokerto','082376432783'),
('S231214132','Pabrik Produk Makanan Inovatif','Pemalang','082376432784'),
('S231214133','Bahan Kering Segar','Tegal','082376432785'),
('S231214134','IndoDaging Distributor','Pekalongan','082376432786'),
('S231214135','Buah Segar Berkah','Pemalang','082376432787'),
('S231214136','Daging Sehat Utama','Pekalongan','082376432788'),
('S231214137','Organik Nusantara','Tegal','082376432789'),
('S231214138','Bumbu Rasa Sejahtera','Brebes','082376432790'),
('S231214139','Air Minum Sehat','Pemalang','082376432791'),
('S231214140','Sumber Susu Berkah','Tegal','082376432792'),
('S231214141','Sentosa Boga Prima','Kudus','082376432793'),
('S231214142','Lautan Ikan Segar','Pati','082376432794'),
('S231214143','Pabrik Bahan Penyedap Inovatif','Rembang','082376432795'),
('S231214144','Berkah Organik','Blora','082376432796'),
('S231214145','Bumbu Segar Jaya','Jepara','082376432797'),
('S231214146','Pemasok Daging Terpercaya','Demak','082376432798'),
('S231214147','IndoBuah Distributor','Semarang','082376432799'),
('S231214148','Rasa Makmur','Magelang','082376432800'),
('S231214149','Mitra Sayur Berkah','Salatiga','082376432801'),
('S231214150','Sentosa Boga Sehat','Solo','082376432802'),
('S231214151','Pabrik Minuman Segar Jaya','Yogyakarta','082376432803');

INSERT INTO bahan (kode_bahan, nama, stok, harga) VALUES
('BN001','Ayam',0,4000),
('BN002','Daging sapi',0,5000),
('BN003','Ikan salmon',0,3500),
('BN004','Udang',0,8000),
('BN005','Telur',0,6000),
('BN006','Tahu',0,3000),
('BN007','Tempe',0,4500),
('BN008','Bawang putih',0,7000),
('BN009','Bawang merah',0,3500),
('BN010','Jahe',0,2000),
('BN011','Serai',0,5500),
('BN012','Lengkuas',0,9000),
('BN013','Kunyit',0,12000),
('BN014','Cabe merah',0,2500),
('BN015','Cabe hijau',0,3000),
('BN016','Buncis',0,4000),
('BN017','Wortel',0,3500),
('BN018','Brokoli',0,1500),
('BN019','Kubis',0,2500),
('BN020','Kacang panjang',0,3000),
('BN021','Kentang',0,2500),
('BN022','Labu siam',0,2000),
('BN023','Labu kuning',0,3500),
('BN024','Paprika',0,4000),
('BN025','Tomat',0,2500),
('BN026','Jamur',0,5000),
('BN027','Lidah buaya',0,7000),
('BN028','Biji wijen',0,10000),
('BN029','Cabe rawit',0,3000),
('BN030','Daun bawang',0,6000),
('BN031','Daun ketumbar',0,1500),
('BN032','Daun kol',0,8000),
('BN033','Daun bayam',0,4500),
('BN034','Daun kemangi',0,3000),
('BN035','Daun salam',0,2500),
('BN036','Daun jeruk',0,2000),
('BN037','Daun pandan',0,3000),
('BN038','Daun pepaya',0,3500),
('BN039','Daun singkong',0,2000),
('BN040','Daun kelor',0,1500),
('BN041','Seledri',0,2500),
('BN042','Rumput laut',0,3000),
('BN043','Teri',0,2000),
('BN044','Cumi-cumi',0,1500),
('BN045','Kerang',0,10000),
('BN046','Ikan teri',0,4000),
('BN047','Ikan tuna',0,1500),
('BN048','Ikan selar',0,2000),
('BN049','Ikan kembung',0,3000),
('BN050','Ikan sarden',0,2500),
('BN051','Ikan patin',0,4000),
('BN052','Ikan lele',0,3000),
('BN053','Ikan gabus',0,2500),
('BN054','Ikan gurame',0,2000),
('BN055','Ikan nila',0,1500),
('BN056','Ikan mujair',0,3000),
('BN057','Ikan bandeng',0,2500),
('BN058','Ikan belanak',0,2000),
('BN059','Ikan kerapu',0,1500),
('BN060','Ikan tenggiri',0,2000),
('BN061','Telur bebek',0,2500),
('BN062','Telur puyuh',0,3000),
('BN063','Susu sapi',0,3500),
('BN064','Susu kedelai',0,4000),
('BN065','Susu almond',0,2500),
('BN066','Keju cheddar',0,2000),
('BN067','Keju mozzarella',0,2500),
('BN068','Keju parmesan',0,1500),
('BN069','Keju feta',0,3000),
('BN070','Keju cream',0,3500),
('BN071','Yogurt',0,2000),
('BN072','Mentega',0,2500),
('BN073','Minyak zaitun',0,3000),
('BN074','Minyak kelapa',0,1500),
('BN075','Minyak sayur',0,4000),
('BN076','Minyak wijen',0,3500),
('BN077','Minyak ikan',0,3000),
('BN078','Minyak biji bunga matahari',0,2000),
('BN079','Biji chia',0,2500),
('BN080','Biji rami',0,1500),
('BN081','Biji kenari',0,2000),
('BN082','Biji bunga matahari',0,3000),
('BN083','Kacang almond',0,2500),
('BN084','Kacang mete',0,2000),
('BN085','Kacang tanah',0,1500),
('BN086','Kacang hijau',0,3000),
('BN087','Kacang merah',0,2500),
('BN088','Kacang kedelai',0,4000),
('BN089','Kacang hitam',0,3500),
('BN090','Kacang putih',0,2000),
('BN091','Kacang polong',0,2500),
('BN092','Kacang panjang',0,3000),
('BN093','Kacang buncis',0,1500),
('BN094','Kacang kapri',0,2000),
('BN095','Kacang hijau muda',0,3000),
('BN096','Kacang tolo',0,2500),
('BN097','Kacang kenari',0,4000),
('BN098','Bawang bombay',0,3500),
('BN099','Bawang daun',0,2000),
('BN100','Bawang prei',0,2500),
('BN101','Seledri batang',0,3000),
('BN102','Seledri daun',0,1500),
('BN103','Seledri bunga',0,2000),
('BN104','Labu kuning',0,3000),
('BN105','Labu air',0,2500),
('BN106','Labu siam',0,4000),
('BN107','Labu parang',0,3500),
('BN108','Labu merah',0,2000),
('BN109','Labu putih',0,2500),
('BN110','Labu manis',0,3000),
('BN111','Labu jipang',0,1500),
('BN112','Labu bunga',0,2000),
('BN113','Labu ular',0,2500),
('BN114','Labu korea',0,3000),
('BN115','Melon',0,4000),
('BN116','Semangka',0,2500),
('BN117','Apel',0,2000),
('BN118','Pisang',0,1500),
('BN119','Mangga',0,3000),
('BN120','Jeruk',0,2500),
('BN121','Anggur',0,4000),
('BN122','Kiwi',0,3500),
('BN123','Strawberry',0,2000),
('BN124','Blueberry',0,2500),
('BN125','Raspberry',0,3000),
('BN126','Blackberry',0,1500),
('BN127','Nangka',0,2000),
('BN128','Durian',0,3000),
('BN129','Salak',0,2500),
('BN130','Rambutan',0,4000),
('BN131','Manggis',0,3500),
('BN132','Pepaya',0,2000),
('BN133','Pinang',0,2500),
('BN134','Jambu biji',0,3000),
('BN135','Alpukat',0,1500),
('BN136','Ceri',0,2000),
('BN137','Persik',0,3000),
('BN138','Plum',0,2500),
('BN139','Nenas',0,4000),
('BN140','Markisa',0,3500),
('BN141','Tomat cherry',0,2000),
('BN142','Cranberry',0,2500),
('BN143','Buah delima',0,3000),
('BN144','Kurma',0,1500),
('BN145','Kismis',0,2000),
('BN146','Biji labu',0,2500),
('BN147','Biji aprikot',0,3000),
('BN148','Biji ara',0,4000),
('BN149','Biji wijen hitam',0,3500),
('BN150','Biji pinus',0,2000);

INSERT INTO menu (kode_menu, nama, stok, harga) VALUES
('MN001','Ayam Goreng Tepung',0,30000),
('MN002','Capcay Sayuran',0,40000),
('MN003','Ikan Bakar Sambal Matah',0,80000),
('MN004','Tumis Sayur Bawang Putih',0,60000),
('MN005','Nasi Goreng Seafood',0,12000),
('MN006','Salad Buah Segar',0,7000),
('MN007','Mie Goreng Tahu Telur',0,15000),
('MN008','Soto Ayam',0,10000),
('MN009','Rendang Daging',0,120000),
('MN010','Pasta Aglio e Olio',0,50000),
('MN011','Gado-gado',0,20000),
('MN012','Ikan Goreng Tepung Asam Manis',0,35000),
('MN013','Sayur Asem',0,30000),
('MN014','Nasi Goreng Jawa',0,45000),
('MN015','Sambal Matah',0,25000),
('MN016','Sup Toma',0,30000),
('MN017','Lodeh Sayuran',0,35000),
('MN018','Sate Ayam Bumbu Kacang',0,25000),
('MN019','Sop Buntut',0,20000),
('MN020','Bebek Goreng Crispy',0,35000);

INSERT INTO detail_bahan VALUES
('MN001','BN001',5),
('MN001','BN002',4),
('MN001','BN003',2),
('MN001','BN004',4),
('MN001','BN005',1),
('MN002','BN016',5),
('MN002','BN017',4),
('MN002','BN018',2),
('MN002','BN019',4),
('MN002','BN008',1),
('MN002','BN014',5),
('MN002','BN004',4),
('MN003','BN055',2),
('MN003','BN009',4),
('MN003','BN008',1),
('MN003','BN029',5),
('MN003','BN036',4),
('MN003','BN024',2),
('MN003','BN003',4),
('MN004','BN018',1),
('MN004','BN017',5),
('MN004','BN005',4),
('MN004','BN003',2),
('MN005','BN084',4),
('MN005','BN004',1),
('MN005','BN003',5),
('MN005','BN005',4),
('MN005','BN008',2),
('MN005','BN014',4),
('MN006','BN117',5),
('MN006','BN119',4),
('MN006','BN121',2),
('MN006','BN122',4),
('MN006','BN065',1),
('MN006','BN108',5),
('MN007','BN085',4),
('MN007','BN006',2),
('MN007','BN005',4),
('MN007','BN009',1),
('MN007','BN014',5),
('MN008','BN028',4),
('MN008','BN008',2),
('MN008','BN010',4),
('MN008','BN011',1),
('MN008','BN030',5),
('MN008','BN009',4),
('MN008','BN122',2),
('MN009','BN002',4),
('MN009','BN009',1),
('MN009','BN008',5),
('MN009','BN011',4),
('MN009','BN036',2),
('MN009','BN014',4),
('MN010','BN083',1),
('MN010','BN073',5),
('MN010','BN008',4),
('MN010','BN004',2),
('MN010','BN032',4),
('MN010','BN012',1),
('MN011','BN020',5),
('MN011','BN006',4),
('MN011','BN005',2),
('MN011','BN048',4),
('MN011','BN085',1),
('MN011','BN046',5),
('MN011','BN122',4),
('MN012','BN060',2),
('MN012','BN002',4),
('MN012','BN116',1),
('MN012','BN091',5),
('MN012','BN008',4),
('MN012','BN014',2),
('MN012','BN005',4),
('MN013','BN020',1),
('MN013','BN095',5),
('MN013','BN022',4),
('MN013','BN025',2),
('MN013','BN116',4),
('MN013','BN009',1),
('MN013','BN032',5),
('MN014','BN084',4),
('MN014','BN014',2),
('MN014','BN005',4),
('MN014','BN009',1),
('MN014','BN008',5),
('MN014','BN093',4),
('MN015','BN009',2),
('MN015','BN008',4),
('MN015','BN029',1),
('MN015','BN025',5),
('MN015','BN011',4),
('MN015','BN036',2),
('MN015','BN024',4),
('MN016','BN025',1),
('MN016','BN017',5),
('MN016','BN008',4),
('MN016','BN009',2),
('MN016','BN122',4),
('MN016','BN091',1),
('MN016','BN004',5),
('MN017','BN022',4),
('MN017','BN020',2),
('MN017','BN006',4),
('MN017','BN035',1),
('MN017','BN009',5),
('MN017','BN008',4),
('MN018','BN028',2),
('MN018','BN085',4),
('MN018','BN014',1),
('MN018','BN009',5),
('MN018','BN008',4),
('MN018','BN011',2),
('MN018','BN036',4),
('MN019','BN002',1),
('MN019','BN017',5),
('MN019','BN048',4),
('MN019','BN009',2),
('MN019','BN008',4),
('MN019','BN030',1),
('MN019','BN010',5),
('MN020','BN030',4),
('MN020','BN002',2),
('MN020','BN008',4),
('MN020','BN004',1),
('MN020','BN007',5),
('MN020','BN035',4),
('MN020','BN005',2);
```

Sesuaikan email dan password aplikasi
```sh
private String GMail = "emailmu@gmail.com";
private String pass = "abcd abcd abcd abcd";
```


=======
> Nur Fatiq (09040622071)
> Mohammad Ulil Azmi Al Huraibi (09050622083)
> Muhammad Al Fatih (09020620034)

