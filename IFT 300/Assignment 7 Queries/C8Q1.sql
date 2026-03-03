/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 02/28/2026      Chapter 8 Assignment Question 1
*/
SELECT 
CAST (InvoiceTotal AS decimal(15,2)) AS DecimalTotal,
CAST (InvoiceTotal AS varchar) AS VarcharTotal,
CONVERT(decimal(15,2), InvoiceTotal) AS ConDecimal,
CONVERT(varchar, InvoiceTotal, 1) AS ConVarchar1
FROM Invoices