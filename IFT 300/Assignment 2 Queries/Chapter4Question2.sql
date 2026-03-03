/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 01/31/2026      Chapter 4 Assignment Question 2
*/
SELECT v.VendorName , i.InvoiceNumber , i.InvoiceDate, 
i.InvoiceTotal - (i.PaymentTotal + i.CreditTotal) AS Balance 
FROM Vendors v
JOIN Invoices i ON v.VendorID = i.InvoiceID
WHERE i.InvoiceTotal - (i.PaymentTotal + i.CreditTotal) > 0

ORDER BY VendorName;
