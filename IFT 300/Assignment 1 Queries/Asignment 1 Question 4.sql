/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 01/23/2026      Chapter 3 Assignment Question 4
*/
SELECT
InvoiceTotal,
InvoiceTotal * .10 AS "10%",
InvoiceTotal + (InvoiceTotal*.10) AS "Plus 10%"
FROM Invoices 
WHERE InvoiceTotal > 1000 ORDER BY InvoiceTotal;