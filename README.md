# Cafe2K
Cafe2Kadalah aplikasi untuk memanjemen cafe sederhana; 

## Tech
##### Perangkat Lunak
- JDK 8
- NetBeans IDE 15
- PostgreSQL 14

##### Liblary
- PostgreSQL JDBC Driver `NetBeans`
- Absolute Layout `NetBeans`
- EnclipseLink (JPA 2.1) `NetBeans`
- [Library lainnya](https://drive.google.com/drive/folders/12aqJtgMWrztnQLhqt8XpMU1gMrIvPGSz?usp=sharing)


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
   JUMLAH_MENU          INT4                 null,
   JUMLAH_BAHAN         INT4                 null,
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
   KODE_MENU            CHAR(5)              not null,
   TANGGAL              DATE                 null,
   KETERANGAN           VARCHAR(100)         null,
   NO_MASAK             CHAR(10)             not null,
   constraint PK_MEMASAK primary key (ID_PEGAWAI, KODE_MENU, NO_MASAK)
);

/*==============================================================*/
/* Index: MEMASAK_PK                                            */
/*==============================================================*/
create unique index MEMASAK_PK on MEMASAK (
ID_PEGAWAI,
KODE_MENU,
NO_MASAK
);

/*==============================================================*/
/* Index: MELAKUKAN_FK                                          */
/*==============================================================*/
create  index MELAKUKAN_FK on MEMASAK (
ID_PEGAWAI
);

/*==============================================================*/
/* Index: MEMILIKI_FK                                           */
/*==============================================================*/
create  index MEMILIKI_FK on MEMASAK (
KODE_MENU
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

alter table MEMASAK
   add constraint FK_MEMASAK_MEMILIKI_MENU foreign key (KODE_MENU)
      references MENU (KODE_MENU)
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


=======
> Nur Fatiq (09040622071)
> Mohammad Ulil Azmi Al Huraibi (09050622083)
> Muhammad Al Fatih (09020620034)

