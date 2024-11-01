import java.util.Scanner;
public class NokiaMenu{
	public static void main(String[] main){
	  Scanner input = new Scanner(System.in);
	  
	  for(;;) {
		System.out.println("Menu:");
		System.out.print("1.\tPhone book\n2.\tMessages\n3.\tChat\n4.\tCall register\n5.\tTones\n6.\tSettings\n7.\tCall divert\n8.\tGames\n9.\tCalculator\n10.\tReminders\n11.\tClock\n12.\tProfiles\n13.\tSIM services\n>>>> ");
		int value = input.nextInt();
		
		switch (value){
			case 1:
				System.out.println("Phone book:");
        System.out.print("1.\tSearch\n2.\tService Nos.\n3.\tAdd name\n4.\tErase\n5.\tEdit\n6.\tAssign tone\n7.\tSend b'card\n8.\tOption\n9.\tSpeed dials\n10.\tVoice tags\n>>>> ");
        int phonebook = input.nextInt();
		        
		        switch (phonebook){
			        case 1:
				        System.out.println("Search");
				        break;
			        case 2:
				        System.out.println("Service Nos.");
				        break;
			        case 3:
				        System.out.println("Add name");
				        break;
				      case 4:
				        System.out.println("Erase");
				        break;
				      case 5:
				        System.out.println("Edit");
				        break;
				      case 6:
				        System.out.println("Assign tone");
				        break;
				      case 7:
				        System.out.println("Send b\'card");
				        break;
				      case 8:
				        System.out.println("Options:");
				        System.out.print("1.\tType of view\n2.\tMemory status\n>>>> ");
                value = input.nextInt();
		            switch (value){
			            case 1:
				            System.out.println("Type of view:");
				            break;
			            case 2:
				            System.out.println("Memory status:");
				            break;
			            default:
				            break;
		            }
				        break;
				      case 9:
				        System.out.println("Speed dials");
				        break;
				      case 10:
				        System.out.println("Voice tags");
				        break;
			        default:
				        break;
		        }
				break;
			case 2:
				System.out.println("Messages:");
				System.out.print("1.\tWrite messages\n2.\tInbox\n3.\tOutbox\n4.\tPicture messages\n5.\tTemplates\n6.\tSmileys\n7.\tMessage settings\n8.\tInfo service\n9.\tVoice mailbox number\n10.\tService command editor\n>>>> ");
        value = input.nextInt();
        switch (value){
			    case 1:
				    System.out.println("Write messages");
				    break;
			    case 2:
				    System.out.println("Inbox:");
				    break;
			    case 3:
				    System.out.println("Outbox");
				    break;
				  case 4:
				    System.out.println("Picture messages");
				    break;
			    case 5:
				    System.out.println("Templates");
				    break;
			    case 6:
				    System.out.println("Smileys");
				    break;
				  case 7:
		        System.out.println("Message settings:");
		        System.out.print("1.\tSet 1\n2.\tCommon\n>>>> ");
		        value = input.nextInt();
		        switch (value){
			        case 1:
				        System.out.println("Set 1:");
			        System.out.print("1.\tMessage centre number\n2.\tMessages sent as\n3.\tMessage validity\n>>>> ");
			        value = input.nextInt();			
			        switch (value){
			        case 1:
				        System.out.println("Message centre number");
				        break;
			        case 2:
				        System.out.println("Messages sent as");
				        break;
			        case 3:
				        System.out.println("Message validity");
				        break;
			        default:
				        break;
		        }
				        break;
			        case 2:
				        System.out.println("Common:");
				        System.out.print("1.\tDelivery reports\n2.\tReply via same centre\n3.\tCharacter support\n>>>> ");
			        value = input.nextInt();			
			        switch (value){
			        case 1:
				        System.out.println("Delivery reports");
				        break;
			        case 2:
				        System.out.println("Reply via same centre");
				        break;
			        case 3:
				        System.out.println("Character support");
				        break;
			        default:
				        break;
		        }
				        break;
			        default:
				        break;
		        }
				            
				    break;
			    case 8:
				    System.out.println("Info service");
				    break;
			    case 9:
				    System.out.println("Voice mailbox number");
				    break;
				  case 10:
				    System.out.println("Service command editor");
				    break;
			    default:
				    break;
		    }
				break;
			case 3:
				System.out.println("Chat");
				break;
			case 4:
				System.out.println("Call register:");
				System.out.print("1.\tMissed calls\n2.\tReceived calls\n3.\tDialled numbers\n4.\tErase recent call lists\n5.\tShow call duration\n6.\tShow call costs\n7.\tCall cost settings\n8.\tPrepaid credit\n>>>> ");
		    value = input.nextInt();
		
		    switch (value){
			    case 1:
				    System.out.println("Missed calls");
				    break;
			    case 2:
				    System.out.println("Received calls");
				    break;
			    case 3:
				    System.out.println("Dialled numbers");
				    break;
			    case 4:
				    System.out.println("Erase recent call lists");
				    break;
			    case 5:
				    System.out.println("Show call duration:");
				    System.out.print("1.\tLast call duration\n2.\tAll calls\' duration\n3.\tReceived calls\' duration\n4.\tDialled calls\' duration\n5.\tClear timers\n>>>> ");
				    value = input.nextInt();
				    switch (value){
					    case 1:
						    System.out.println("Last call duration");
						    break;
					    case 2:
						    System.out.println("All calls\' duration");
						    break;
					    case 3:
						    System.out.println("Received calls\' duration");
						    break;
					    case 4:
						    System.out.println("Dialled calls\' duration");
						    break;
					    case 5:
						    System.out.println("Clear timers");
						    break;
					    default:
						    break;
			      }
			      break;
			    case 6:
				    System.out.println("Show call costs:");
				    System.out.print("1.\tLast call cost\n2.\tAll calls\' cost\n3.\tClear counters\n>>>> ");
				    value = input.nextInt();
				    switch (value){
					    case 1:
						    System.out.println("Last call cost");
						    break;
					    case 2:
						    System.out.println("All calls\' cost");
						    break;
					    case 3:
						    System.out.println("Clear counters");
						    break;
					    default:
						    break;
				    }
				    break;
			  case 7:
				  System.out.println("Call cost settings:");
				  System.out.print("1.\tCall cost limit\n2.\tShow costs in\n>>>> ");
				  value = input.nextInt();
				  switch (value){
					  case 1:
						  System.out.println("Call cost limit");
						  break;
					  case 2:
						  System.out.println("Show costs in");
						  break;
					  default:
						  break;
				  }
				  break;
			  case 8:
				  System.out.println("Prepaid credit");
				  break;
			  default:
				  break;
		    }
				break;
			case 5:
				System.out.println("Tones:");
				System.out.print("1.\tRinging tone\n2.\tRinging volume\n3.\tIncoming call alert\n4.\tComposer\n5.\tMessage alert tone\n6.\tKeypad tones\n7.\tWarning and game tones\n8.\tVibrating alert\n9.\tScreen saver\n>>>> ");
				value = input.nextInt();
				switch (value){
					case 1:
						System.out.println("Ringing tone");
						break;
					case 2:
						System.out.println("Ringing volume");
						break;
					case 3:
						System.out.println("Incoming call alert");
						break;
					case 4:
						System.out.println("Composer");
						break;
					case 5:
						System.out.println("Message alert tone");
						break;
					case 6:
						System.out.println("Keypad tones");
						break;
					case 7:
						System.out.println("Warning and game tones");
						break;
					case 8:
						System.out.println("Vibrating alert");
						break;
					case 9:
						System.out.println("Screen saver");
						break;
					default:
						break;
				}
				break;
			case 6:
				System.out.println("Settings:");
				System.out.print("1.\tCall settings\n2.\tPhone settings\n3.\tSecurity settings\n4.\tComposer\n>>>> ");
				value = input.nextInt();
				switch (value){
					case 1:
						System.out.println("Call settings:");
						System.out.print("1.\tAutomatic redial\n2.\tSpeed dialling\n3.\tCall waiting options\n4.\tOwn number sending\n5.\tPhone line in use\n6.\tAutomatic answer\n>>>> ");
				    value = input.nextInt();
				    switch (value){
					    case 1:
						    System.out.println("Automatic redial");
						    break;
					    case 2:
						    System.out.println("Speed dialling");
						    break;
					    case 3:
						    System.out.println("Call waiting options");
						    break;
					    case 4:
						    System.out.println("Own number sending");
						    break;
					    case 5:
						    System.out.println("Phone line in use");
						    break;
					    case 6:
						    System.out.println("Automatic answer");
						    break;
					    default:
						    break;
				    }
						break;
					case 2:
						System.out.println("Phone settings:");
						System.out.print("1.\tLanguage\n2.\tCell info display\n3.\tWelcome note\n4.\tNetwork selection\n5.\tLights\n6.\tConfirm SIM service actions\n>>>> ");
				    value = input.nextInt();
				    switch (value){
					    case 1:
						    System.out.println("Language");
						    break;
					    case 2:
						    System.out.println("Cell info display");
						    break;
					    case 3:
						    System.out.println("Welcome note");
						    break;
					    case 4:
						    System.out.println("Network selection");
						    break;
					    case 5:
						    System.out.println("Lights");
						    break;
					    case 6:
						    System.out.println("Confirm SIM service actions");
						    break;
					    default:
						    break;
				    }
						break;
					case 3:
						System.out.println("Security settings:");
						System.out.print("1.\tPIN code request\n2.\tCall barring service\n3.\tFixed dialling\n4.\tClosed user group\n5.\tPhone security\n6.\tChange access codes\n>>>> ");
				    value = input.nextInt();
				    switch (value){
					    case 1:
						    System.out.println("PIN code request");
						    break;
					    case 2:
						    System.out.println("Call barring service");
						    break;
					    case 3:
						    System.out.println("Fixed dialling");
						    break;
					    case 4:
						    System.out.println("Closed user group");
						    break;
					    case 5:
						    System.out.println("Phone security");
						    break;
					    case 6:
						    System.out.println("Change access codes");
						    break;
					    default:
						    break;
				    }
						break;
					case 4:
						System.out.println("Restore factory settings");
						break;
					default:
						break;
				}
				break;
			case 7:
				System.out.println("Call divert");
				break;
			case 8:
				System.out.println("Games");
				break;
			case 9:
				System.out.println("Calculator");
				break;
			case 10:
				System.out.println("Reminders");
				break;
			case 11:
				System.out.println("Clock:");
				System.out.print("1.\tAlarm clock\n2.\tClock settings\n3.\tDate setting\n4.\tStopwatch\n5.\tCountdown timer\n6.\tAuto update of date and time\n>>>> ");
		    value = input.nextInt();
		    switch (value){
			    case 1:
				    System.out.println("Alarm clock");
				    break;
			    case 2:
				    System.out.println("Clock settings");
				    break;
			    case 3:
				    System.out.println("Date setting");
				    break;
			    case 4:
				    System.out.println("Stopwatch");
				    break;
			    case 5:
				    System.out.println("Countdown timer");
				    break;
			    case 6:
				    System.out.println("Auto update of date and time");
				    break;
			    default:
				    break;
		    }
				break;
			case 12:
				System.out.println("Profiles");
				break;
			case 13:
				System.out.println("SIM services");
				break;
			default:
				break;
		}
		}
}
}
