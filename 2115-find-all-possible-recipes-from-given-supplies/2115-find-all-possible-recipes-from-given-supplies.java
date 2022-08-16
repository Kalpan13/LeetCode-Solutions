class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> ans = new ArrayList<>();
        int n = recipes.length;
        Map<String,Integer> pendingInds = new HashMap<>(); // Count of ingredients that are unavailable for each recipe
        Set<String> availableInds = new HashSet<>(Arrays.asList(supplies)); // currently available ingredients
        
        Map<String,Set<String>> ingredientsMod = new HashMap<>(); // Modified ingredients
        Queue<String> q = new LinkedList<>(); // Queue for BFS on recipes
        
        for(int i=0;i<n;i++)
        {
            String recipeName = recipes[i];
            List<String> requiredInds = ingredients.get(i); // List of required ingredients
            pendingInds.putIfAbsent(recipeName,0);
            for(String requiredInd: requiredInds)
            {
                if(!availableInds.contains(requiredInd))
                {
                    pendingInds.put(recipeName, pendingInds.get(recipeName)+1);
                    ingredientsMod.putIfAbsent(requiredInd, new HashSet<>());
                    ingredientsMod.get(requiredInd).add(recipeName);
                }
            }

            if(pendingInds.get(recipeName)==0)
                q.offer(recipeName);
        }
        while(!q.isEmpty())
        {
            String recipe = q.poll(); // All ingredients available for this recipe
            ans.add(recipe);
            for(String pendingRecipe: ingredientsMod.getOrDefault(recipe,new HashSet<>()))
            {
                pendingInds.put(pendingRecipe,pendingInds.get(pendingRecipe)-1);
                if(pendingInds.get(pendingRecipe)==0)
                    q.offer(pendingRecipe);
                
            }
        }
        return ans;
        
    }
}