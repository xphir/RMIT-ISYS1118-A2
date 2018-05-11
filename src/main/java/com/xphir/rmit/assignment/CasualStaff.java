package com.xphir.rmit.assignment;

import java.util.*;

public class CasualStaff
{
	Scanner scan = new Scanner(System.in);
	public String csID, firstName, lastName, title, email;
	private static final int maxIDlen = 20, maxFNlen = 20, maxLNlen = 20, maxTitlelen = 10;
	private ArrayList<String> qualification = new ArrayList<>();
	/*public CasualStaff(String csID, String )
	{
		
	}*/
	
	public String getCasualStaffID()
	{
		return csID;
	}
	
	public void editCasualStaff()
	{
		String input = null;
		int index = 0;
		boolean exit = false;
		
		while(exit != true)
		{
			try
			{
				printMenu();
				input = scan.nextLine();
				index = Integer.parseInt(input);
				if(index == 1)
				{
					while(Integer.parseInt(input)!=0)
					{
						System.out.printf("\nEnter the new ID (to cancel enter 0):\n");
						input = scan.nextLine();
						if(input.length() > maxIDlen)
						{
							throw new InputException("invalid input");
						}
						else if(Integer.parseInt(input)==0)
						{
							break;
						}
						else
						{
							this.csID = input;
							break;
						}
					}
				}
				else if(index == 2)
				{
					while(Integer.parseInt(input)!=0)
					{
						System.out.printf("\nEnter the new First name (to cancel enter 0):\n");
						input = scan.nextLine();
						if(input.length() > maxFNlen)
						{
							throw new InputException("invalid input");
						}
						else if(Integer.parseInt(input)==0)
						{
							break;
						}
						else
						{
							this.firstName = input;
							break;
						}
					}
				}
				else if(index == 3)
				{
					while(Integer.parseInt(input)!=0)
					{
						System.out.printf("\nEnter the new Last name (to cancel enter 0):\n");
						input = scan.nextLine();
						if(input.length() > maxLNlen)
						{
							throw new InputException("invalid input");
						}
						else if(Integer.parseInt(input)==0)
						{
							break;
						}
						else
						{
							this.lastName = input;
							break;
						}
					}
				}
				else if(index == 4)
				{
					while(Integer.parseInt(input)!=0)
					{
						System.out.printf("\nEnter the new Title (to cancel enter 0):\n");
						input = scan.nextLine();
						if(input.length() > maxTitlelen)
						{
							throw new InputException("invalid input");
						}
						else if(Integer.parseInt(input)==0)
						{
							break;
						}
						else
						{
							this.title = input;
							break;
						}
					}
				}
				else if(index == 5)
				{
					while(Integer.parseInt(input)!=0)
					{
						System.out.printf("\nEnter the new Email address (to cancel enter 0):\n");
						input = scan.nextLine();
						if(!input.contains(".com"))
						{
							throw new InputException("invalid Email address");
						}
						else if(Integer.parseInt(input)==0)
						{
							break;
						}
						else
						{
							this.email = input;
						}
					}
				}
				else if(index == 6)
				{
					while(Integer.parseInt(input)!=0)
					{
						System.out.printf("\nEnter a new qualification (to cancel enter 0):\n");
						input = scan.nextLine();
						if(this.qualification.contains(input))
						{
							throw new InputException("already existing (duplicate qualification)");
						}
						else if(Integer.parseInt(input)==0)
						{
							break;
						}
						else
						{
							this.qualification.add(input);
						}
					}
				}
				else if(index == 0)
				{
					exit = true;
					break;
				}
				else
				{
					throw new InputException("Cannot read input");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	public void viewQualification()
	{
		int counter = 1;
		System.out.println();
		for(String qual : qualification)
		{
			System.out.printf("%d.%s\n",counter,qual);
			counter++;
		}
	}
	
	public void deleteQualification(String qual)
	{
		qualification.remove(qual);
		System.out.printf("\n%s deleted", qual);
	}
	
	public void addQualification(String qual)
	{
		qualification.add(qual);
		System.out.printf("\n%s added", qual);
	}
	
	public void printMenu()
	{
		System.out.printf("\n---Choose what to edit for Staff %s---\n",this.csID);
		System.out.printf("1.Staff ID\n2.First name\n3.Last name\n4.Staff title\n5.Email address\n6.Add staff qualification\n0.CANCEL\n\n---type in the index to choose which to edit---\n");		
	}
}
