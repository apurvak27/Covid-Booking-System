# Problem Description 

The University of Knowledge (UoK) has decided to actively help to stop the spread of COVID-19 by offering free
COVID tests on campus to their students. The UoK needs your help to develop a booking system. To develop such
a system, you need to consider additional functions beyond the booking rules. For instance, you need to consider the
availability of resources — infrastructure and people — and the constraints of the current health policies.
The UoK will offer rooms, from 7AM to 10AM, where the tests can be performed, and it is asking for volunteers
to apply to become COVID-19 test assistants; they will be working under the supervision of a GP. Hence, the UoK
needs to handle repositories for these resources. Regarding the health policies, UoK needs to guarantee a minimum
time-slot between consecutive tests to allow for proper sanitation of the facilities.
Rooms and assistants registered in the university resource system are not automatically available for booking. The
booking system will interact with the existing university system to create bookable rooms and to create assistant shifts.
Thus, a room is different from a bookable room because the latter is anchored in time; a room in the university system
is represented by multiple bookable rooms in the booking system. Similarly, assistants in the university are different
from assistant on shift in the booking system. Finally, the system will offer booking slots based on the availability of
bookable rooms and assistants of shift.


