/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 02/08/2026      Chapter 5 Assignment Question 3
*/
SELECT v.VendorName, COUNT(*) AS InvoiceCount, SUM(i.InvoiceTotal)
FROM Vendors v JOIN Invoices i ON v.VendorID=i.InvoiceID
GROUP BY v.VendorName
ORDER BY InvoiceCount