import java.util.Scanner;
public class NokiaMenuReturnQuitAndTryAgain{
	public static void main(String[] main){
	  Scanner input = new Scanner(System.in);
	  int level1 = 0;
    int level2 = 0;
    int level3 = 0;
    int level4 = 0;
    int level5 = 0;
    int sentinel = 1;
    String message;
    
    while(sentinel != -1){
		  if (level1 == 0){
		    message = "Menu:\n1.\tPhone book\n2.\tMessages\n3.\tChat\n4.\tCall register\n5.\tTones\n6.\tSettings\n7.\tCall divert\n8.\tGames\n9.\tCalculator\n10.\tReminders\n11.\tClock\n12.\tProfiles\n13.\tSIM services\n\n-1.\t ❌ Quit\n>>>> ";
        System.out.print(message);
        level1 = input.nextInt(); 
      }
		  switch (level1){
			  case 1:
          if (level2 == 0){
            message = "Phone book:\n1.\tSearch\n2.\tService Nos.\n3.\tAdd name\n4.\tErase\n5.\tEdit\n6.\tAssign tone\n7.\tSend b'card\n8.\tOption\n9.\tSpeed dials\n10.\tVoice tags\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt(); 
          }
	        switch (level2){
		          case 1:
		            if (level3 == 0){
			            message = "Search\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			          
		          case 2:
			          if (level3 == 0){
			            message = "Service Nos.\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
			          }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
                  
		          case 3:
			          if (level3 == 0){
			            message = "Add name\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
			          }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			        case 4:
			          if (level3 == 0){
			            message = "Erase\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
			          }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			        case 5:
			          if (level3 == 0){
			            message = "Edit\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
			          }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			        case 6:
			          if (level3 == 0){
			            message = "Assign tone\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
			          }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			        case 7:
			          if (level3 == 0){
			            message = "Send b\'card\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
			          }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			        case 8:
                if (level3 == 0){
			            message = "Options:\n1.\tType of view\n2.\tMemory status\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
                  System.out.print(message);
                  level3 = input.nextInt(); 
                }
	              switch (level3){
		              case 1:
		                if (level4 == 0){
			                message = "Type of view:\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			                System.out.print(message);
			                level4 = input.nextInt();
		                }
			              switch(level4){
                        case 0:
                          level3 = 0; level4 = 0;
                          continue;
                        case -1:
                          sentinel = -1;
                          continue;
                        default:
                          System.out.println("Wrong Input - Try Again.");
                          level4 = 0;
                          continue;
                      }
		              case 2:
		                if (level4 == 0){
			                message = "Memory status:\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			                System.out.print(message);
			                level4 = input.nextInt();
		                }
			              switch(level4){
                        case 0:
                          level3 = 0; level4 = 0;
                          continue;
                        case -1:
                          sentinel = -1;
                          continue;
                        default:
                          System.out.println("Wrong Input - Try Again.");
                          level4 = 0;
                          continue;
                      }
			            case 0:
                      level2 = 0; level3 = 0;
                      continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level3 = 0;
                    continue;
			              
	              }
				        case 9:
				          if (level3 == 0){
			              message = "Speed dials\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level3 = input.nextInt();
			            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
				        case 10:
				          if (level3 == 0){
			              message = "Voice tags\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level3 = input.nextInt();
			            }
			            switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
                case 0://phone book last 3 cases
                  level1 = 0; level2 = 0;
                  continue;
			          case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level2 = 0;
                  continue;
		          }
			  case 2:
			    if (level2 == 0){
				    message = "Messages:\n1.\tWrite messages\n2.\tInbox\n3.\tOutbox\n4.\tPicture messages\n5.\tTemplates\n6.\tSmileys\n7.\tMessage settings\n8.\tInfo service\n9.\tVoice mailbox number\n10.\tService command editor\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            level2 = input.nextInt();
			    }
          switch (level2){
			      case 1:
				      if (level3 == 0){
			            message = "Write messages\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			      case 2:
				      if (level3 == 0){
			            message = "Inbox\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			      case 3:
				      if (level3 == 0){
			            message = "Outbox\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
				    case 4:
				      if (level3 == 0){
			            message = "Picture messages\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			      case 5:
				      if (level3 == 0){
			            message = "Templates\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			      case 6:
				      if (level3 == 0){
			            message = "Smileys\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
				    case 7:
				      if (level3 == 0){
		            message = "Message settings:\n1.\tSet 1\n2.\tCommon\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
                level3 = input.nextInt(); 
				      }
		          switch (level3){
			          case 1:
			            if (level4 == 0){
			              message = "Set 1:\n1.\tMessage centre number\n2.\tMessages sent as\n3.\tMessage validity\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
    		            System.out.print(message);
    		            level4 = input.nextInt();			
			            }
			            switch (level4){
			              case 1:
			                if (level5 == 0){
				                message = "Message centre number\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			                  System.out.print(message);
			                  level5 = input.nextInt();
			                }
			                switch(level5){
                        case 0:
                          level4 = 0; level5 = 0;
                          continue;
                        case -1:
                          sentinel = -1;
                          continue;
                        default:
                          System.out.println("Wrong Input - Try Again.");
                          level5 = 0;
                          continue;
                      }

			            case 2:
			              if (level5 == 0){
				              message = "Messages sent as\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			                System.out.print(message);
			                level5 = input.nextInt();
			              }
			              switch(level5){
                        case 0:
                          level4 = 0; level5 = 0;
                          continue;
                        case -1:
                          sentinel = -1;
                          continue;
                        default:
                          System.out.println("Wrong Input - Try Again.");
                          level5 = 0;
                          continue;
                      }
			            case 3:
			              if (level5 == 0){
				              message = "Message validity\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			                System.out.print(message);
			                level5 = input.nextInt();
			              }
			              switch(level5){
                        case 0:
                          level4 = 0; level5 = 0;
                          continue;
                        case -1:
                          sentinel = -1;
                          continue;
                        default:
                          System.out.println("Wrong Input - Try Again.");
                          level5 = 0;
                          continue;
                    }
			            case 0:
                    level3 = 0; level4 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level4 = 0;
                    continue;				            
		            }
		            
			          case 2:
			            if (level4 == 0){
				            message = "Common:\n1.\tDelivery reports\n2.\tReply via same centre\n3.\tCharacter support\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
				            System.out.print(message);
			              level4 = input.nextInt();			
			            }
			            switch (level4){
			              case 1:
			                if (level5 == 0){
				                message = "Delivery reports\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			                  System.out.print(message);
			                  level5 = input.nextInt();
			                }
			                switch(level5){
                        case 0:
                          level4 = 0; level5 = 0;
                          continue;
                        case -1:
                          sentinel = -1;
                          continue;
                        default:
                          System.out.println("Wrong Input - Try Again.");
                          level5 = 0;
                          continue;
                      }

			              case 2:
				              System.out.println("");
				              if (level5 == 0){
				                message = "Reply via same centre\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			                  System.out.print(message);
			                  level5 = input.nextInt();
			                }
			                switch(level5){
                        case 0:
                          level4 = 0; level5 = 0;
                          continue;
                        case -1:
                          sentinel = -1;
                          continue;
                        default:
                          System.out.println("Wrong Input - Try Again.");
                          level5 = 0;
                          continue;
                      }
			              case 3:
				              System.out.println("");
				              if (level5 == 0){
				                message = "Character support\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			                  System.out.print(message);
			                  level5 = input.nextInt();
			                }
			                switch(level5){
                        case 0:
                          level4 = 0; level5 = 0;
                          continue;
                        case -1:
                          sentinel = -1;
                          continue;
                        default:
                          System.out.println("Wrong Input - Try Again.");
                          level5 = 0;
                          continue;
                      }
				            case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
		              }
		            case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
		          }
			      case 8:
				      if (level3 == 0){
			            message = "Info service\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			      case 9:
				      if (level3 == 0){
			            message = "Voice mailbox number\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
				    case 10:
				      if (level3 == 0){
			            message = "Service command editor\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                }
			      case 0:
              level1 = 0; level2 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level2 = 0;
              continue;
		    }
			  case 3:
				  if (level2 == 0){
            message = "Chat\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt();
          }
          switch(level2){
              case 0:
                level1 = 0; level2 = 0;
                continue;
              case -1:
                sentinel = -1;
                continue;
              default:
                System.out.println("Wrong Input - Try Again.");
                level2 = 0;
                continue;
          }
				  
			  case 4:
			    if (level2 == 0){
				    message = "Call register:\n1.\tMissed calls\n2.\tReceived calls\n3.\tDialled numbers\n4.\tErase recent call lists\n5.\tShow call duration\n6.\tShow call costs\n7.\tCall cost settings\n8.\tPrepaid credit\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
		        level2 = input.nextInt();
			    }
		  
		      switch (level2){
			      case 1:
              if (level3 == 0){
			            message = "Missed calls\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			      case 2:
              if (level3 == 0){
			            message = "Received calls\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
		          switch(level3){
                  case 0:
                    level2 = 0; level3 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level3 = 0;
                    continue;
                }
			      case 3:
				      if (level3 == 0){
			            message = "Dialled numbers\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			      case 4:
				      if (level3 == 0){
			            message = "Erase recent call lists\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                    case 0:
                      level2 = 0; level3 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level3 = 0;
                      continue;
                  }
			      case 5:
			        if (level3 == 0){
				        message = "Show call duration:\n1.\tLast call duration\n2.\tAll calls\' duration\n3.\tReceived calls\' duration\n4.\tDialled calls\' duration\n5.\tClear timers\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
			        }
				      switch (level3){
					      case 1:
					        if (level4 == 0){
						        message = "Last call duration\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		                System.out.print(message);
		                level4 = input.nextInt();
					        }
		              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 2:
						      if (level4 == 0){
						        message = "All calls\' duration\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		                System.out.print(message);
		                level4 = input.nextInt();
					        }
		              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                    }
					      case 3:
						      if (level4 == 0){
						        message = "Received calls\' duration\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		                System.out.print(message);
		                level4 = input.nextInt();
					        }
		              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                    }
					      case 4:
					        if (level4 == 0){
                    message = "Dialled calls\' duration\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		                System.out.print(message);
		                level4 = input.nextInt();
					        }
		              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                    }
					      case 5:
						      if (level4 == 0){
                    message = "Clear timers\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		                System.out.print(message);
		                level4 = input.nextInt();
					        }
		              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                    }
					      case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
			        }
			      case 6:
			        if (level3 == 0){
				        message = "Show call costs:\n1.\tLast call cost\n2.\tAll calls\' cost\n3.\tClear counters\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
				        System.out.print(message);
				        level3 = input.nextInt();
			        }
				      switch (level3){
					      case 1:
						      if (level4 == 0){
						      message = "Last call cost:\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		              System.out.print(message);
		              level4 = input.nextInt();
		              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                    }
						      
					      case 2:
						      if (level4 == 0){
						        message = "All calls\' cost:\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		                System.out.print(message);
		                level4 = input.nextInt();
		              }
		              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                    }
					      case 3:
						      if (level4 == 0){
						        message = "Clear counters\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		                System.out.print(message);
		                level4 = input.nextInt();
		              }
		              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                    }
						    case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
				      }
			    case 7:
				    if (level3 == 0){
				      message = "Call cost settings:\n 1.\tCall cost limit\n2.\tShow costs in\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
              System.out.print(message);
              level3 = input.nextInt(); 
            }
				    switch (level3){
					    case 1:
						    if (level4 == 0){
	                message = "Call cost limit\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
	                System.out.print(message);
	                level4 = input.nextInt();
	              }
	              switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					    case 2:
						    if (level4 == 0){
	                message = "Show costs in\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
	                System.out.print(message);
	                level4 = input.nextInt();
	              }
	              switch(level4){
                  case 0:
                    level3 = 0; level4 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level4 = 0;
                    continue;
                }
              case 0:
                level3 = 0; level4 = 0;
                continue;
              case -1:
                sentinel = -1;
                continue;
              default:
                System.out.println("Wrong Input - Try Again.");
                level4 = 0;
                continue;
				    }
			    case 8:
				    if (level3 == 0){
			            message = "Prepaid credit\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
            }
	          switch(level3){
              case 0:
                level2 = 0; level3 = 0;
                continue;
              case -1:
                sentinel = -1;
                continue;
              default:
                System.out.println("Wrong Input - Try Again.");
                level3 = 0;
                continue;
              }
		      }
			  case 5:
				  if (level2 == 0){
            message = "Tones:\n1.\tRinging tone\n2.\tRinging volume\n3.\tIncoming call alert\n4.\tComposer\n5.\tMessage alert tone\n6.\tKeypad tones\n7.\tWarning and game tones\n8.\tVibrating alert\n9.\tScreen saver\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt();
				  }
				  switch (level2){
					  case 1:
						  if (level3 == 0){
		            message = "Ringing tone\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 2:
						  if (level3 == 0){
		            message = "Ringing volume\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 3:
						  if (level3 == 0){
		            message = "Incoming call alert\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 4:
						  if (level3 == 0){
		            message = "Composer\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 5:
						  if (level3 == 0){
		            message = "Message alert tone\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 6:
						  if (level3 == 0){
		            message = "Keypad tones\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 7:
						  if (level3 == 0){
		            message = "Warning and game tones\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 8:
						  if (level3 == 0){
		            message = "Vibrating alert\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 9:
						  if (level3 == 0){
		            message = "Screen saver\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		            System.out.print(message);
		            level3 = input.nextInt();
	            }
		          switch(level3){
                case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
              }
					  case 0:
              level2 = 0; level3 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level3 = 0;
              continue;
				  }
				  
				  
				  
				  
				  
			  case 6:
			    if (level2 == 0){
				      message = "Settings:\n1.\tCall settings\n2.\tPhone settings\n3.\tSecurity settings\n4.\tRestore factory settings\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
				      System.out.println(message);
              level2 = input.nextInt();
		      }
				  switch (level2){
					  case 1:
					  if (level3 == 0){
						  message = "Call settings:\n1.\tAutomatic redial\n2.\tSpeed dialling\n3.\tCall waiting options\n4.\tOwn number sending\n5.\tPhone line in use\n6.\tAutomatic answer\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
				      System.out.print(message);
				      level3 = input.nextInt();
				    }
				      switch (level3){
					      case 1:
					        if (level4 == 0){
						        message = "Automatic redial\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 2:
						      if (level4 == 0){
						        message = "Speed dialling\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 3:
						      if (level4 == 0){
						        message = "Call waiting options\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 4:
						      if (level4 == 0){
						        message = "Own number sending\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 5:
						      if (level4 == 0){
						        message = "Phone line in use\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 6:
						      System.out.println("");
						      if (level4 == 0){
						        message = "Automatic answer\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
				      }
					  case 2:
					    if (level3 == 0){
						    message = "Phone settings:\n1.\tLanguage\n2.\tCell info display\n3.\tWelcome note\n4.\tNetwork selection\n5.\tLights\n6.\tConfirm SIM service actions\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
						    System.out.print(message);
				        level3 = input.nextInt();
					    }
				      switch (level3){
					      case 1:
						      if (level4 == 0){
						        message = "Language\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 2:
						      if (level4 == 0){
						        message = "Cell info display\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 3:
						      if (level4 == 0){
						        message = "Welcome note\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 4:
						      if (level4 == 0){
						        message = "Network selection\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 5:
						      if (level4 == 0){
						        message = "Lights\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 6:
						      if (level4 == 0){
						        message = "Confirm SIM service actions\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
				      }
					  case 3:
						  if (level3 == 0){
						  message = "Security settings:\n1.\tPIN code request\n2.\tCall barring service\n3.\tFixed dialling\n4.\tClosed user group\n5.\tPhone security\n6.\tChange access codes\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
				      System.out.print(message);
				      level3 = input.nextInt();
				    }
				      switch (level3){
					      case 1:
						      if (level4 == 0){
						        message = "PIN code request\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 2:
						      if (level4 == 0){
						        message = "Call barring service\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 3:
						      if (level4 == 0){
						        message = "Fixed dialling\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 4:
						      if (level4 == 0){
						        message = "Closed user group\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 5:
						      if (level4 == 0){
						        message = "Phone security\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 6:
						      if (level4 == 0){
						        message = "Change access codes\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			              System.out.print(message);
			              level4 = input.nextInt();
					        }
					        switch(level4){
                    case 0:
                      level3 = 0; level4 = 0;
                      continue;
                    case -1:
                      sentinel = -1;
                      continue;
                    default:
                      System.out.println("Wrong Input - Try Again.");
                      level4 = 0;
                      continue;
                  }
					      case 0:
                  level2 = 0; level3 = 0;
                  continue;
                case -1:
                  sentinel = -1;
                  continue;
                default:
                  System.out.println("Wrong Input - Try Again.");
                  level3 = 0;
                  continue;
				      }
					  case 4:
						  if (level3 == 0){
					        message = "Restore factory settings\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
		              System.out.print(message);
		              level3 = input.nextInt();
				        }
				        switch(level3){
                  case 0:
                    level3 = 0; level4 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level4 = 0;
                    continue;
                  }
					  case 0:
              level2 = 0; level3 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level3 = 0;
              continue;
				  }
				  
			  case 7:
				  if (level2 == 0){
            message = "Call divert\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt(); 
          }
          switch(level2){
            case 0:
              level1 = 0; level2 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level2 = 0;
              continue;
          }
			  case 8:
				  if (level2 == 0){
            message = "Games\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt(); 
          }
          switch(level2){
            case 0:
              level1 = 0; level2 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level2 = 0;
              continue;
          }
			  case 9:
				  if (level2 == 0){
            message = "Calculator\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt(); 
          }
          switch(level2){
            case 0:
              level1 = 0; level2 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level2 = 0;
              continue;
          }
			  case 10:
				  if (level2 == 0){
            message = "Reminders\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt(); 
          }
          switch(level2){
            case 0:
              level1 = 0; level2 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level2 = 0;
              continue;
          }
			  case 11:
			    if (level2 == 0){
				    message = "Clock:\n1.\tAlarm clock\n2.\tClock settings\n3.\tDate setting\n4.\tStopwatch\n5.\tCountdown timer\n6.\tAuto update of date and time\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
		        level2 = input.nextInt();
			    }
		      switch (level2){
			      case 1:
				      if (level3 == 0){
			            message = "Alarm clock\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                  case 0:
                    level2 = 0; level3 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level3 = 0;
                    continue;
                  }
              
			      case 2:
				      if (level3 == 0){
			            message = "Clock settings\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                  case 0:
                    level2 = 0; level3 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level3 = 0;
                    continue;
                  }
			      case 3:
				      if (level3 == 0){
			            message = "Date setting\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                  case 0:
                    level2 = 0; level3 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level3 = 0;
                    continue;
                  }
			      case 4:
				      if (level3 == 0){
			            message = "Stopwatch\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                  case 0:
                    level2 = 0; level3 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level3 = 0;
                    continue;
                  }
			      case 5:
				      if (level3 == 0){
			            message = "Countdown timer\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                  case 0:
                    level2 = 0; level3 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level3 = 0;
                    continue;
                  }
			      case 6:
				      if (level3 == 0){
			            message = "Auto update of date and time\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
			            System.out.print(message);
			            level3 = input.nextInt();
		            }
			          switch(level3){
                  case 0:
                    level2 = 0; level3 = 0;
                    continue;
                  case -1:
                    sentinel = -1;
                    continue;
                  default:
                    System.out.println("Wrong Input - Try Again.");
                    level3 = 0;
                    continue;
                  }
			      case 0:
              level1 = 0; level2 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level2 = 0;
              continue;
		      }
			  case 12:
				  if (level2 == 0){
            message = "Profiles\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt(); 
          }
          switch(level2){
            case 0:
              level1 = 0; level2 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level2 = 0;
              continue;
          }
			  case 13:
				  if (level2 == 0){
            message = "SIM services\n\n0.\t ↩️  Previous menu\n-1.\t ❌ Quit\n>>>> ";
            System.out.print(message);
            level2 = input.nextInt();
          }
          switch(level2){
            case 0:
              level1 = 0; level2 = 0;
              continue;
            case -1:
              sentinel = -1;
              continue;
            default:
              System.out.println("Wrong Input - Try Again.");
              level2 = 0;
              continue;
          }
			  
        case -1:
          sentinel = -1;
          continue;
        default:
          System.out.println("Wrong Input - Try Again.");
          level1 = 0;
          continue;
		  }
		}
		
  }
}
