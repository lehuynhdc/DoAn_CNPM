USE [QL_DCMPTCT]
GO
/****** Object:  Table [dbo].[ctphieumuon]    Script Date: 5/25/2021 10:54:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ctphieumuon](
	[idpm] [nvarchar](10) NOT NULL,
	[idmathang] [nvarchar](10) NOT NULL,
	[soluong] [int] NOT NULL,
 CONSTRAINT [pk_ctpm] PRIMARY KEY CLUSTERED 
(
	[idpm] ASC,
	[idmathang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ctphieunhap]    Script Date: 5/25/2021 10:54:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ctphieunhap](
	[idpn] [nvarchar](10) NOT NULL,
	[idmathang] [nvarchar](10) NOT NULL,
	[soluong] [int] NOT NULL,
	[gia] [money] NOT NULL,
 CONSTRAINT [pk_ctpn] PRIMARY KEY CLUSTERED 
(
	[idpn] ASC,
	[idmathang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lichsuhu]    Script Date: 5/25/2021 10:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lichsuhu](
	[idmathang] [nvarchar](10) NOT NULL,
	[ngayhu] [date] NOT NULL,
	[soluonghu] [int] NOT NULL,
 CONSTRAINT [PK_lichsuhu] PRIMARY KEY CLUSTERED 
(
	[idmathang] ASC,
	[ngayhu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mathang]    Script Date: 5/25/2021 10:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mathang](
	[idmathang] [nvarchar](10) NOT NULL,
	[tenmathang] [nvarchar](30) NOT NULL,
	[ngaysanxuat] [date] NOT NULL,
	[hansudung] [date] NULL,
 CONSTRAINT [PK_idmathang] PRIMARY KEY CLUSTERED 
(
	[idmathang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ncc]    Script Date: 5/25/2021 10:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ncc](
	[idncc] [nvarchar](10) NOT NULL,
	[tenncc] [nvarchar](20) NOT NULL,
	[diachi] [nvarchar](100) NULL,
 CONSTRAINT [PK_Idncc] PRIMARY KEY CLUSTERED 
(
	[idncc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhanvien]    Script Date: 5/25/2021 10:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhanvien](
	[idnv] [nvarchar](10) NOT NULL,
	[ho] [nvarchar](10) NOT NULL,
	[ten] [nvarchar](10) NOT NULL,
	[gioitinh] [nvarchar](3) NOT NULL,
	[diachi] [nvarchar](100) NULL,
 CONSTRAINT [PK_nhanvien] PRIMARY KEY CLUSTERED 
(
	[idnv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phanquyen]    Script Date: 5/25/2021 10:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phanquyen](
	[idpq] [nvarchar](10) NOT NULL,
	[tenpq] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idpq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieumuon]    Script Date: 5/25/2021 10:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieumuon](
	[idpm] [nvarchar](10) NOT NULL,
	[ngaymuon] [date] NOT NULL,
	[idnv] [nvarchar](10) NOT NULL,
	[datra] [bit] NOT NULL,
 CONSTRAINT [PK__phieumuo__9DB7550D0945F6FD] PRIMARY KEY CLUSTERED 
(
	[idpm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieunhap]    Script Date: 5/25/2021 10:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieunhap](
	[idpn] [nvarchar](10) NOT NULL,
	[ngaynhap] [date] NOT NULL,
	[idnv] [nvarchar](10) NOT NULL,
	[idncc] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK__phieunha__9DB7550E96C5EA98] PRIMARY KEY CLUSTERED 
(
	[idpn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[userCH]    Script Date: 5/25/2021 10:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userCH](
	[username] [nvarchar](20) NOT NULL,
	[passwword] [nvarchar](20) NOT NULL,
	[idpq] [nvarchar](10) NOT NULL,
	[idnv] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK__userCH__F3DBC573B2A74768] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ctphieumuon] ([idpm], [idmathang], [soluong]) VALUES (N'PM1', N'MH1', 1)
INSERT [dbo].[ctphieumuon] ([idpm], [idmathang], [soluong]) VALUES (N'PM1', N'MH2', 1)
INSERT [dbo].[ctphieumuon] ([idpm], [idmathang], [soluong]) VALUES (N'PM1', N'MH3', 1)
INSERT [dbo].[ctphieumuon] ([idpm], [idmathang], [soluong]) VALUES (N'PM1', N'MH4', 1)
INSERT [dbo].[ctphieumuon] ([idpm], [idmathang], [soluong]) VALUES (N'PM2', N'MH2', 1)
INSERT [dbo].[ctphieumuon] ([idpm], [idmathang], [soluong]) VALUES (N'PM2', N'MH5', 1)
INSERT [dbo].[ctphieumuon] ([idpm], [idmathang], [soluong]) VALUES (N'PM3', N'MH3', 4)
GO
INSERT [dbo].[ctphieunhap] ([idpn], [idmathang], [soluong], [gia]) VALUES (N'PN1', N'MH1', 5, 30000.0000)
INSERT [dbo].[ctphieunhap] ([idpn], [idmathang], [soluong], [gia]) VALUES (N'PN1', N'MH2', 5, 15000.0000)
INSERT [dbo].[ctphieunhap] ([idpn], [idmathang], [soluong], [gia]) VALUES (N'PN1', N'MH3', 5, 10000.0000)
INSERT [dbo].[ctphieunhap] ([idpn], [idmathang], [soluong], [gia]) VALUES (N'PN1', N'MH4', 5, 100000.0000)
INSERT [dbo].[ctphieunhap] ([idpn], [idmathang], [soluong], [gia]) VALUES (N'PN1', N'MH5', 5, 20000.0000)
INSERT [dbo].[ctphieunhap] ([idpn], [idmathang], [soluong], [gia]) VALUES (N'PN2', N'MH1', 12, 100000.0000)
INSERT [dbo].[ctphieunhap] ([idpn], [idmathang], [soluong], [gia]) VALUES (N'PN2', N'MH2', 1, 1.0000)
GO
INSERT [dbo].[lichsuhu] ([idmathang], [ngayhu], [soluonghu]) VALUES (N'MH2', CAST(N'2021-02-02' AS Date), 1)
GO
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH1', N'kéo', CAST(N'2001-01-01' AS Date), CAST(N'2021-06-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH10', N'test1', CAST(N'2001-01-01' AS Date), CAST(N'2001-06-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH2', N'Bình xịt nước', CAST(N'2000-03-05' AS Date), CAST(N'2021-06-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH3', N'Lược', CAST(N'2000-02-02' AS Date), CAST(N'2021-06-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH4', N'Tông đơ', CAST(N'2000-02-02' AS Date), CAST(N'2021-06-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH5', N'Thuốc nhuộm', CAST(N'2000-02-02' AS Date), CAST(N'2021-06-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH6', N'Dầu gội', CAST(N'2000-02-02' AS Date), CAST(N'2021-06-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH7', N'test', CAST(N'2001-02-02' AS Date), CAST(N'2021-02-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH8', N'test2', CAST(N'2001-02-01' AS Date), CAST(N'2021-02-01' AS Date))
INSERT [dbo].[mathang] ([idmathang], [tenmathang], [ngaysanxuat], [hansudung]) VALUES (N'MH9', N'test8', CAST(N'2001-01-12' AS Date), CAST(N'2021-06-12' AS Date))
GO
INSERT [dbo].[ncc] ([idncc], [tenncc], [diachi]) VALUES (N'NCC1', N'Ngà', N' ')
INSERT [dbo].[ncc] ([idncc], [tenncc], [diachi]) VALUES (N'NCC2', N'Đức', N' ')
GO
INSERT [dbo].[nhanvien] ([idnv], [ho], [ten], [gioitinh], [diachi]) VALUES (N'NV1', N'Lê', N'Hùng', N'Nam', N' ')
INSERT [dbo].[nhanvien] ([idnv], [ho], [ten], [gioitinh], [diachi]) VALUES (N'NV2', N'Lưu', N'Toàn', N'Nam', N' ')
INSERT [dbo].[nhanvien] ([idnv], [ho], [ten], [gioitinh], [diachi]) VALUES (N'NV3', N'Lê', N'Hương', N'Nữ', N' ')
INSERT [dbo].[nhanvien] ([idnv], [ho], [ten], [gioitinh], [diachi]) VALUES (N'NV4', N'Nguyễn', N'Thảo', N'Nữ', N' ')
GO
INSERT [dbo].[phanquyen] ([idpq], [tenpq]) VALUES (N'PQ1', N'Quản lí')
INSERT [dbo].[phanquyen] ([idpq], [tenpq]) VALUES (N'PQ2', N'Nhân viên')
GO
INSERT [dbo].[phieumuon] ([idpm], [ngaymuon], [idnv], [datra]) VALUES (N'PM1', CAST(N'2021-02-02' AS Date), N'NV2', 1)
INSERT [dbo].[phieumuon] ([idpm], [ngaymuon], [idnv], [datra]) VALUES (N'PM2', CAST(N'2021-03-02' AS Date), N'NV3', 0)
INSERT [dbo].[phieumuon] ([idpm], [ngaymuon], [idnv], [datra]) VALUES (N'PM3', CAST(N'2021-02-02' AS Date), N'NV4', 1)
GO
INSERT [dbo].[phieunhap] ([idpn], [ngaynhap], [idnv], [idncc]) VALUES (N'PN1', CAST(N'2021-01-01' AS Date), N'NV1', N'NCC1')
INSERT [dbo].[phieunhap] ([idpn], [ngaynhap], [idnv], [idncc]) VALUES (N'PN2', CAST(N'2021-02-01' AS Date), N'NV1', N'NCC1')
GO
INSERT [dbo].[userCH] ([username], [passwword], [idpq], [idnv]) VALUES (N'hung', N'123', N'PQ1', N'NV1')
INSERT [dbo].[userCH] ([username], [passwword], [idpq], [idnv]) VALUES (N'huong', N'123', N'PQ2', N'NV3')
INSERT [dbo].[userCH] ([username], [passwword], [idpq], [idnv]) VALUES (N'Thao', N'123', N'PQ2', N'NV4')
INSERT [dbo].[userCH] ([username], [passwword], [idpq], [idnv]) VALUES (N'toan', N'123', N'PQ2', N'NV2')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_username]    Script Date: 5/25/2021 10:54:49 PM ******/
ALTER TABLE [dbo].[nhanvien] ADD  CONSTRAINT [UK_username] UNIQUE NONCLUSTERED 
(
	[idnv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_idnv]    Script Date: 5/25/2021 10:54:49 PM ******/
ALTER TABLE [dbo].[userCH] ADD  CONSTRAINT [UK_idnv] UNIQUE NONCLUSTERED 
(
	[idnv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ncc] ADD  DEFAULT (' ') FOR [diachi]
GO
ALTER TABLE [dbo].[nhanvien] ADD  CONSTRAINT [DF__nhanvien__diachi__34C8D9D1]  DEFAULT (' ') FOR [diachi]
GO
ALTER TABLE [dbo].[ctphieumuon]  WITH CHECK ADD  CONSTRAINT [FK__ctphieumu__idmat__35BCFE0A] FOREIGN KEY([idmathang])
REFERENCES [dbo].[mathang] ([idmathang])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ctphieumuon] CHECK CONSTRAINT [FK__ctphieumu__idmat__35BCFE0A]
GO
ALTER TABLE [dbo].[ctphieumuon]  WITH CHECK ADD  CONSTRAINT [FK__ctphieumuo__idpm__36B12243] FOREIGN KEY([idpm])
REFERENCES [dbo].[phieumuon] ([idpm])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ctphieumuon] CHECK CONSTRAINT [FK__ctphieumuo__idpm__36B12243]
GO
ALTER TABLE [dbo].[ctphieunhap]  WITH CHECK ADD  CONSTRAINT [FK__ctphieunh__idmat__37A5467C] FOREIGN KEY([idmathang])
REFERENCES [dbo].[mathang] ([idmathang])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ctphieunhap] CHECK CONSTRAINT [FK__ctphieunh__idmat__37A5467C]
GO
ALTER TABLE [dbo].[ctphieunhap]  WITH CHECK ADD  CONSTRAINT [FK__ctphieunha__idpn__38996AB5] FOREIGN KEY([idpn])
REFERENCES [dbo].[phieunhap] ([idpn])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ctphieunhap] CHECK CONSTRAINT [FK__ctphieunha__idpn__38996AB5]
GO
ALTER TABLE [dbo].[lichsuhu]  WITH CHECK ADD  CONSTRAINT [FK_lichsuhu_mathang] FOREIGN KEY([idmathang])
REFERENCES [dbo].[mathang] ([idmathang])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[lichsuhu] CHECK CONSTRAINT [FK_lichsuhu_mathang]
GO
ALTER TABLE [dbo].[phieumuon]  WITH CHECK ADD  CONSTRAINT [FK_phieumuon_nhanvien] FOREIGN KEY([idnv])
REFERENCES [dbo].[nhanvien] ([idnv])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[phieumuon] CHECK CONSTRAINT [FK_phieumuon_nhanvien]
GO
ALTER TABLE [dbo].[phieunhap]  WITH CHECK ADD  CONSTRAINT [FK_phieunhap_ncc] FOREIGN KEY([idncc])
REFERENCES [dbo].[ncc] ([idncc])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[phieunhap] CHECK CONSTRAINT [FK_phieunhap_ncc]
GO
ALTER TABLE [dbo].[phieunhap]  WITH CHECK ADD  CONSTRAINT [FK_phieunhap_nhanvien] FOREIGN KEY([idnv])
REFERENCES [dbo].[nhanvien] ([idnv])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[phieunhap] CHECK CONSTRAINT [FK_phieunhap_nhanvien]
GO
ALTER TABLE [dbo].[userCH]  WITH CHECK ADD  CONSTRAINT [FK__userCH__idpq__3E52440B] FOREIGN KEY([idpq])
REFERENCES [dbo].[phanquyen] ([idpq])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[userCH] CHECK CONSTRAINT [FK__userCH__idpq__3E52440B]
GO
ALTER TABLE [dbo].[userCH]  WITH CHECK ADD  CONSTRAINT [FK_userCH_nhanvien] FOREIGN KEY([idnv])
REFERENCES [dbo].[nhanvien] ([idnv])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[userCH] CHECK CONSTRAINT [FK_userCH_nhanvien]
GO
ALTER TABLE [dbo].[ctphieumuon]  WITH CHECK ADD  CONSTRAINT [CK_ctphieumuon_soluong] CHECK  (([soluong]>(0)))
GO
ALTER TABLE [dbo].[ctphieumuon] CHECK CONSTRAINT [CK_ctphieumuon_soluong]
GO
ALTER TABLE [dbo].[ctphieunhap]  WITH CHECK ADD  CONSTRAINT [CK_ctphieunhap_gia] CHECK  (([gia]>(0)))
GO
ALTER TABLE [dbo].[ctphieunhap] CHECK CONSTRAINT [CK_ctphieunhap_gia]
GO
ALTER TABLE [dbo].[ctphieunhap]  WITH CHECK ADD  CONSTRAINT [CK_ctphieunhap_soluong] CHECK  (([soluong]>(0)))
GO
ALTER TABLE [dbo].[ctphieunhap] CHECK CONSTRAINT [CK_ctphieunhap_soluong]
GO
ALTER TABLE [dbo].[lichsuhu]  WITH CHECK ADD  CONSTRAINT [CK_ngayhu] CHECK  (([ngayhu]>'2000-1-1'))
GO
ALTER TABLE [dbo].[lichsuhu] CHECK CONSTRAINT [CK_ngayhu]
GO
ALTER TABLE [dbo].[lichsuhu]  WITH CHECK ADD  CONSTRAINT [CK_soluonghu] CHECK  (([soluonghu]>=(0)))
GO
ALTER TABLE [dbo].[lichsuhu] CHECK CONSTRAINT [CK_soluonghu]
GO
ALTER TABLE [dbo].[mathang]  WITH CHECK ADD  CONSTRAINT [CK_mathang_HSD] CHECK  (([hansudung]>[ngaysanxuat]))
GO
ALTER TABLE [dbo].[mathang] CHECK CONSTRAINT [CK_mathang_HSD]
GO
ALTER TABLE [dbo].[mathang]  WITH CHECK ADD  CONSTRAINT [CK_mathang_ngaysanxuat] CHECK  (([ngaysanxuat]>='2000-01-01'))
GO
ALTER TABLE [dbo].[mathang] CHECK CONSTRAINT [CK_mathang_ngaysanxuat]
GO
ALTER TABLE [dbo].[nhanvien]  WITH CHECK ADD  CONSTRAINT [CK__nhanvien__gioitinh] CHECK  (([GioiTinh]=N'Nam' OR [GioiTinh]=N'Nữ'))
GO
ALTER TABLE [dbo].[nhanvien] CHECK CONSTRAINT [CK__nhanvien__gioitinh]
GO
ALTER TABLE [dbo].[phieumuon]  WITH CHECK ADD  CONSTRAINT [CK_phieumuon_ngaymuon] CHECK  (([ngaymuon]>'2000-1-1'))
GO
ALTER TABLE [dbo].[phieumuon] CHECK CONSTRAINT [CK_phieumuon_ngaymuon]
GO
ALTER TABLE [dbo].[phieunhap]  WITH CHECK ADD  CONSTRAINT [CK_phieunhap_ngaynhap] CHECK  (([ngaynhap]>'2000-1-1'))
GO
ALTER TABLE [dbo].[phieunhap] CHECK CONSTRAINT [CK_phieunhap_ngaynhap]
GO
