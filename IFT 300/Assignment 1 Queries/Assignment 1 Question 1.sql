/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 01/23/2026      Chapter 3 Assignment Question 1
*/
SELECT VendorContactFName, VendorContactLName, VendorName 
	FROM Vendors 
	ORDER BY VendorContactLName ASC, VendorContactFName ASC;