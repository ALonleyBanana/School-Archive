/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 02/08/2026      Chapter 5 Assignment Question 2
*/
SELECT TOP(10) v.VendorName 
,SUM(i.PaymentTotal) AS PaymentSum
FROM Invoices i
JOIN Vendors v ON v.VendorID =i.InvoiceID
GROUP BY v.VendorName
ORDER BY PaymentSum DESC


