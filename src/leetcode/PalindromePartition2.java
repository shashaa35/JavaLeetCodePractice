package leetcode;

//https://www.youtube.com/watch?v=qmTtAbOTqcg
//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartition2 {

    public int minCut(String str)
    {
        // Get the length of the string
        int n = str.length();

		/* Create two arrays to build the solution
		in bottom up manner
		C[i][j] = Minimum number of cuts needed
					for palindrome partitioning
					of substring str[i..j]
		P[i][j] = true if substring str[i..j] is
					palindrome, else false
		Note that C[i][j] is 0 if P[i][j] is
		true */
        int[][] C = new int[n][n];
        boolean[][] P = new boolean[n][n];

        int i, j, k, gap; // different looping variables
        for (gap = 0; gap < n; gap++) {
            for (i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    P[i][j] = true;
                } else if (gap == 1)
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];
            }
        }

        for (gap = 0; gap < n; gap++) {
            for (i = 0, j = gap; j < n; i++, j++) {
                if (P[i][j]) {
                    C[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (k = i;k<j;k++) {
                        int left = C[i][k];
                        int right = C[k+1][j];
                        if (left + right + 1 < min) {
                            min = left + right + 1;
                        }
                    }
                    C[i][j] = min;
                }

            }
        }

        return C[0][n - 1];
    }

    public static void main(String[] args) {
        PalindromePartition2 obj = new PalindromePartition2();
        System.out.println(obj.minCut("aaabaa"));
        System.out.println(obj.minCut("ab"));
        System.out.println(obj.minCut("a"));
        System.out.println(obj.minCut("aaaa"));
        System.out.println(obj.minCut("aab"));
        System.out.println(obj.minCut("fiefhgdcdcgfeibggchibffahiededbbegegdfibdbfdadfbdbceaadeceeefiheibahgececggaehbdcgebaigfacifhdbecbebfhiefchaaheiichgdbheacfbhfiaffaecicbegdgeiaiccghggdfggbebdaefcagihbdhhigdgbghbahhhdagbdaefeccfiaifffcfehfcdiiieibadcedibbedgfegibefagfccahfcbegdfdhhdgfhgbchiaieehdgdabhidhfeecgfiibediiafacagigbhchcdhbaigdcedggehhgdhedaebchcafcdehcffdiagcafcgiidhdhedgaaegdchibhdaegdfdaiiidcihifbfidechicighbcbgibadbabieaafgeagfhebfaheaeeibagdfhadifafghbfihehgcgggffgbfccgafigieadfehieafaehaggeeaaaehggffccddchibegfhdfafhadgeieggiigacbfgcagigbhbhefcadafhafdiegahbhccidbeeagcgebehheebfaechceefdiafgeddhdfcadfdafbhiifigcbddahbabbeedidhaieagheihhgffbfbiacgdaifbedaegbhigghfeiahcdieghhdabdggfcgbafgibiifdeefcbegcfcdihaeacihgdchihdadifeifdgecbchgdgdcifedacfddhhbcagaicbebbiadgbddcbagbafeadhddaeebdgdebafabghcabdhdgieiahggddigefddccfccibifgbfcdccghgceigdfdbghdihechfabhbacifgbiiiihcgifhdbhfcaiefhccibebcahidachfabicbdabibiachahggffiibbgchbidfbbhfcicfafgcagaaadbacddfiigdiiffhbbehaaacidggfbhgeaghigihggfcdcidbfccahhgaffiibbhidhdacacdfebedbiacaidaachegffaiiegeabfdgdcgdacfcfhdcbfiaaifgfaciacfghagceaaebhhibbieehhcbiggabefbeigcbhbcidbfhfcgdddgdffghidbbbfbdhcgabaagddcebaechbbiegeiggbabdhgghciheabdibefdfghbfbfebidhicdhbeghebeddgfdfhefebiiebdchifbcbahaddhbfafbbcebiigadhgcfbebgbebhfddgdeehhgdegaeedfadegfeihcgeefbbagbbacbgggciehdhiggcgaaicceeaefgcehfhfdciaghcbbgdihbhecfbgffefhgiefgeiggcebgaacefidghdfdhiabgibchdicdehahbibeddegfciaeaffgbefbbeihbafbagagedgbdadfdggfeaebaidchgdbcifhahgfdcehbahhdggcdggceiabhhafghegfdiegbcadgaecdcdddfhicabdfhbdiiceiegiedecdifhbhhfhgdbhibbdgafhgdcheefdhifgddchadbdggiidhbhegbdfdidhhfbehibiaacdfbiagcbheabaaebfeaeafbgigiefeaeheabifgcfibiddadicheahgbfhbhddaheghddceedigddhchecaghdegigbegcbfgbggdgbbigegffhcfcbbebdchffhddbfhhfgegggibhafiebcfgeaeehgdgbccbfghagfdbdfcbcigbigaccecfehcffahiafgabfcaefbghccieehhhiighcfeabffggfchfdgcfhadgidabdceediefdccceidcfbfiiaidechhbhdccccaigeegcaicabbifigcghcefaafaefd"));
        System.out.println(obj.minCut("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"));
    }
}
