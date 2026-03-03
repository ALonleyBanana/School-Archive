/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 02/28/2026      Chapter 8 Assignment Question 2
*/
SELECT
CAST (InvoiceDate AS Varchar) AS DateVarchar,
TRY_CONVERT(varchar, InvoiceDate, 1) AS DateVarchar1,
TRY_CONVERT(varchar, InvoiceDate, 10) AS DateVarchar10
FROM Invoices