package leetcode;

//https://www.youtube.com/watch?v=lDYIvtBVmgo
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

        int i, j, k, L; // different looping variables
        for (L = 1; L <= n; L++) {
            // For substring of length L, set different
            // possible starting indexes
            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1; // Set ending index
                if (L==1) {
                    P[i][j] = true;
                } else if (L == 2)
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];

                // IF str[i..j] is palindrome, then
                // C[i][j] is 0
                if (P[i][j])
                    C[i][j] = 0;
                else {
                    // Make a cut at every possible
                    // localtion starting from i to j,
                    // and get the minimum cost cut.
                    C[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++)
                        C[i][j] = Integer.min(C[i][j],
                                C[i][k] + C[k + 1][j] + 1);
                }
            }
        }

        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
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
