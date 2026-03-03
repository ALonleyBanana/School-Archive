/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 02/15/2026      Chapter 6 Assignment Question 3
*/
SELECT InvoiceNumber, InvoiceTotal
FROM Invoices
WHERE PaymentTotal > (SELECT (SELECT MAX(PaymentTotal) FROM (SELECT TOP 50 PERCENT PaymentTotal FROM Invoices ORDER BY PaymentTotal ASC) AS Bot) 
+ (SELECT MIN(PaymentTotal) FROM (SELECT TOP 50 PERCENT PaymentTotal FROM Invoices ORDER BY PaymentTotal DESC) as topH)
/2 AS Median)